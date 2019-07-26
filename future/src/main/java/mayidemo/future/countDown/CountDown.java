package mayidemo.future.countDown;

import java.util.concurrent.CountDownLatch;

public class CountDown {

    static CountDownLatch countDownLatch = new CountDownLatch(10);

    public void s1(){
        for(int i = 0;i < 10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread run");
                }
            }).start();

            countDownLatch.countDown();
        }

    }

    public static void main(String[] args) {

        CountDown countDown = new CountDown();
        countDown.s1();

    }
}
