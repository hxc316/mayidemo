package mayidemo.future.test;

import mayidemo.future.FutureApplicationTests;
import mayidemo.future.chap01.FutureData;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class FutureDataTest extends FutureApplicationTests {

    @Autowired
    FutureData futureData;

    @Test
    public void test1(){
        futureData.future();
    }
}
