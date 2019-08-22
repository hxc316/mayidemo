package mayidemo.bird.logUtil;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
@Slf4j
public class LogTask {
    @Autowired
    LogService logService;

    @PostConstruct
    public void log(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                        try{
                            LogUserDto logUserDto = LogUtil.take();
                            log.info(" >> 获取你的日志 ,保存到数据库  data = " + new Gson().toJson(logUserDto));
                            if(!logService.saveLog(logUserDto)){
                                LogUtil.add(logUserDto);
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }catch (Exception e){
                            log.error("保存日志失败",e);
                        }
                    }
            }
        }).start();
    }

}
