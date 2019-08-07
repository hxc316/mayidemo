package mayidemo.bird.paramsnull;

import mayidemo.bird.BirdApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MServiceTest extends BirdApplicationTests {

    @Autowired
    MService mService;

    @Test
    public void test1(){
        mService.m();
    }

}
