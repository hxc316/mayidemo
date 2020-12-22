package mayidemo.future.chap01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Slf4j
@Component
public class FutureData {

    private static ExecutorService executorPool = Executors.newFixedThreadPool(8);

    /**
     * 异步执行任务
     */
    public void future(){
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("我需要3秒");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "1";
        }, executorPool).exceptionally((e) -> {
            log.info("1 error", e);
            return "-1";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("我需要2秒");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "2";
        }, executorPool).exceptionally((e) -> {
            log.info("2 error", e);
            return "-2";
        });

        CompletableFuture<Void> futureAll = CompletableFuture.allOf(future1, future2);
        futureAll.join();

        try {
            String s1 = future1.get(3, TimeUnit.SECONDS);
            String s2 = future2.get(3, TimeUnit.SECONDS);
            log.info(" >>>>>>> future result : s1 = {} , s2 = {}", s1 , s2 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return;
    }
}
