package mayidemo.future.sync;

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
}
