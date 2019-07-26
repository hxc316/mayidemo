package mayidemo.future.countDown;

import java.util.concurrent.CountDownLatch;

public class A1 {

    private static final CountDownLatch countDownLatch = new CountDownLatch(1);

    class M1 implements Runnable{
        @Override
        public void run() {
            try {
                countDownLatch.await();
                System.out.println("do run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void d1(){
        for(int i =0;i<10;i++){
            new Thread(new M1()).start();
        }
    }

    public static void main(String[] args) {
        A1 a1= new A1();
        a1.d1();
        countDownLatch.countDown();
        try {
            Thread.currentThread();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
