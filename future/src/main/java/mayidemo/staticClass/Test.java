package mayidemo.staticClass;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Test {
    static CountDownLatch  end = new CountDownLatch(2);
    static CountDownLatch begin = new CountDownLatch(1);
    static CountDownLatch stop = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        A.M m = new A.M();
        m.setNum(1);
        for(int i =0;i<1500;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        begin.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a.s(m);
                }
            }).start();
        }


        A b = new A();
        A.M n = new A.M();
        n.setNum(2);
        for(int i =0;i<1000;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        begin.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    b.s(n);
                }
            }).start();
        }

        begin.countDown();
        stop.await(3, TimeUnit.SECONDS);

        System.out.println("A :" + a.getSum());
        System.out.println("B :" + b.getSum());

        try {
            end.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
