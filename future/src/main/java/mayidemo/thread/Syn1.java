package mayidemo.thread;

public class Syn1 {

    public static int i = 0;
    Thread t1 = null;
    Thread t2 = null;

    public void s1(){
        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (Syn1.class){
                    for(int j=0;j<100000;j++){
                        i++;
                    }
                }
            }
        });
        t1.start();
    }

    public void s2(){
        t2= new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (Syn1.class){
                    for(int j=0;j<100000;j++){
                        i++;
                    }
                }
            }
        });
        t2.start();
    }


    public static void main(String[] args) throws InterruptedException {
        Syn1 syn1 = new Syn1();
        syn1.s1();
        syn1.s2();
        Thread t3 =new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (Syn1.class){
                    for(int i=0;i<100000;i++){
                        syn1.i++;
                    }
                }
            }
        });

        t3.start();
        t3.join();
        syn1.t1.join();
        syn1.t2.join();

        System.out.println(syn1.i);
    }
}
