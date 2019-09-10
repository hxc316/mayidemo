package mayidemo.thread;

public class Syn3 {

    public int i =0;

    public synchronized void s1(){
        for(int j = 0;j< 100000;j++){
            i++;
        }
    }

    public  void s2(){
        synchronized (this){
            for(int m=0;m<100000;m++){
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Syn3 syn3 = new Syn3();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                syn3.s1();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                syn3.s2();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(syn3.i);
    }
}
