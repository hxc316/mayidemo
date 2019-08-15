package mayidemo.future.sync;

import org.springframework.stereotype.Component;

@Component
public class DataService {


    public String getData(String i){
        try {
            Thread.sleep((long) (Math.random()*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i + "x";
    }

    public static void main(String[] args) {
        System.out.println((long) (Math.random()*1000));
    }
}
