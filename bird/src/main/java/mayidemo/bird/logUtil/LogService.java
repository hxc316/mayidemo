package mayidemo.bird.logUtil;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class LogService {

    public boolean saveLog(LogUserDto logUserDto){
        log.info("保存日志 data = id : {} , plat : {}" , logUserDto.getId(),logUserDto.getPlat());
        return true;
    }

//    @PostConstruct
    public void init(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while (true){
                    System.out.println("添加日志到队列 data = " + new Gson().toJson(new LogUserDto(1l,100)));
                    LogUtil.add(new LogUserDto(1l,100));
                    System.out.println(++i);
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
