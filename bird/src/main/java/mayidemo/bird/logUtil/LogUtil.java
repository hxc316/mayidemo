package mayidemo.bird.logUtil;

import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingDeque;

@Component
public class LogUtil {

    private static LinkedBlockingDeque<LogUserDto> logsDeque = new LinkedBlockingDeque<>();

    public static void  add(LogUserDto logUserDto){
        if(logUserDto != null){
            logsDeque.offer(logUserDto);
        }
    }

    public LogUserDto take(){
        try {
            return logsDeque.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
