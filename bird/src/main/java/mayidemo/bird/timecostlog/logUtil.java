package mayidemo.bird.timecostlog;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
public class logUtil {
    public static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.S";
    static ThreadLocal<List<Data>> dates = new ThreadLocal<>();
    public static void add(String msg){
        if(dates.get() == null){
            dates.set(new ArrayList<>());
        }
        List<Data> dateList = dates.get();
        Date date =new Date();
        long cost = 0;
        if(dateList.size() != 0){
             cost = date.getTime() - dateList.get(dateList.size()-1).getDate().getTime();
        }
        Data data = new Data(date, StringUtils.isNotEmpty(msg)?msg:"",cost);
        dates.get().add(data);
    }

    public static void out(){
        dates.get().stream().forEach(item ->{
            log.info("{} 步骤【{}】: 耗时 = {}]", DateFormatUtils.format(item.getDate(),FORMAT_FULL),item.getMsg(), item.getCost());
        });
    }


    @lombok.Data
    @AllArgsConstructor
    static class Data{
        private Date date;
        private String msg;
        private Long cost;
    }

    public static void main(String[] args) {
        logUtil.add("111");
        logUtil.add("222");
        logUtil.out();
    }

}
