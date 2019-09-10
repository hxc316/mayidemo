package mayidemo.future.sync;

import java.util.HashSet;
import java.util.Set;

public class DataRepliate {

    Set<String> data = new HashSet<>();

    public synchronized void  put(String value){
       if( data.contains(value)){
           System.out.println(">>>>> 已经存在" + value);
           return;
       }
       data.add(value);
    }
}
