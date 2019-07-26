package mayidemo.future.countDown;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicInt {

    AtomicInteger atomicInteger = new AtomicInteger(0);
    final static CountDownLatch countDownLatch = new CountDownLatch(1);


    public void s1(){
        for(int i = 0;i<100;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int i = atomicInteger.addAndGet(2);
                    System.out.println( "i = " + i);
                }
            }).start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicInt atomic = new AtomicInt();
        atomic.s1();
        countDownLatch.countDown();
        Thread.currentThread();
        Thread.sleep(3000);

    }

}
