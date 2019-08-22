package mayidemo.notify;

public class Notify1 {

    public static boolean done = false;

    public void s(){
        for(int i=0;i<3;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (this){
                        while(!done){
                            try {
                                wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(11);
                    }
                }
            }).start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Notify1 a1 = new Notify1();
        Thread.sleep(1000);
            synchronized (a1){
            a1.done = true;
            a1.notify();
        }

        a1.s();
    }
}
