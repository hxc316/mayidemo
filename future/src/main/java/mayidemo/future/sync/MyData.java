package mayidemo.future.sync;

import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class MyData {
    private static ExecutorService executorPool = Executors.newFixedThreadPool(20);
    @Autowired
    DataService dataService;
    CountDownLatch countDownLatch = new CountDownLatch(1);


    public List<DataDto> init(){
        List<DataDto> list = new ArrayList<>();
        for(int i =0;i<100;i++){
            DataDto dataDto = new DataDto();
            dataDto.setData(i+"");
            list.add(dataDto);
        }
        return list;
    }

    public void myData() throws InterruptedException {
        List<DataDto> list = init();
        CountDownLatch count = new CountDownLatch(list.size());
        for(DataDto d : list){
            CompletableFuture.supplyAsync(() -> dataService.getData(d.getData()),executorPool).whenComplete((result, exception) ->{
                d.setData(result);
//                log.info("whenComplete = {}",result);
                count.countDown();
            });
        }
        count.await();
        log.info("--------------------------------------");
        list.forEach(dataDto -> {
            log.info(dataDto.getData());
        });
        log.info("--------------------------------------");

//        countDownLatch.await();
    }


    public void ss(){
        List<DataDto> list = init();
        CountDownLatch count = new CountDownLatch(list.size());

        Integer i = 1;
        for(DataDto dataDto : list){
            executorPool.submit(new Runnable() {
                @Override
                public void run() {

                    System.out.println(dataDto.getData());
                    count.countDown();
                }
            });
        }

        executorPool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    count.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("==========================end=====================================");
            }
        });

    }



    CountDownLatch end = new CountDownLatch(1);


    private static Object lock = new Object();
    public void ss2() throws InterruptedException {
        CountDownLatch count = new CountDownLatch(2000);
        DataDto data2 = new DataDto();
        data2.setData("0");
        final Integer j = 1;
        for(int i = 0; i<2000; i++){
            executorPool.submit(new Runnable() {
                @Override
                public void run() {
                    synchronized (lock){
                        String data = data2.getData();
                        data2.setData(Integer.parseInt(data) + 1 + "");
                    }
                    count.countDown();
                }
            });
        }

        executorPool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    count.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("data = " + data2.getData());
                System.out.println("==========================end=====================================");
                end.countDown();
            }
        });

        end.await();

    }

    DataRepliate dataRepliate = new DataRepliate();
    ThreadLocal<DataDto> countLocal = new ThreadLocal<>();

    public void ss3() throws InterruptedException {
        CountDownLatch count = new CountDownLatch(2000);

        final Integer j = 1;
        for(int i = 0; i<2000; i++){
            executorPool.submit(new Runnable() {
                @Override
                public void run() {
                        DataDto data2 = new DataDto();
                        data2.setData("0");
                        countLocal.set(data2);
                        DataDto dataDto = countLocal.get();
                        String data = dataDto.getData();
                        dataDto.setData(Integer.parseInt(data) + 1 + "");
                        String d = dataDto.getData();
                        System.out.println(d);
//                        dataRepliate.put(d);
                    count.countDown();
                }
            });
        }

        executorPool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    count.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                System.out.println("data = " + data2.getData());
                System.out.println("==========================end=====================================");
                end.countDown();
            }
        });

        end.await();

    }


    public static void main(String[] args) {

    }
}
