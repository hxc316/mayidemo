package mayidemo.bird.logutil;

import com.google.gson.Gson;
import mayidemo.bird.BirdApplicationTests;
import mayidemo.bird.logUtil.LogUserDto;
import mayidemo.bird.logUtil.LogUtil;
import org.junit.Test;

public class LogTest extends BirdApplicationTests {

    @Test
    public void s1(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("添加日志到队列 data = " + new Gson().toJson(new LogUserDto(1l,100)));
                    LogUtil.add(new LogUserDto(1l,100));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
