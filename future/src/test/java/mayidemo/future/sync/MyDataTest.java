package mayidemo.future.sync;

import mayidemo.future.FutureApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MyDataTest extends FutureApplicationTests {

    @Autowired
    private MyData myData;

    @Test
    public void s() throws InterruptedException {
        myData.myData();
    }



    @Test
    public void mm(){
        myData.ss();
    }

    @Test
    public void ss(){
        try {
            myData.ss2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ss3(){
        try {
            myData.ss3();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
