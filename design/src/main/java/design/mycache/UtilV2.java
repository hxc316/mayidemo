package design.mycache;

import java.util.HashMap;
import java.util.function.Function;

public class UtilV2<T,R> {

    private HashMap<Object,R> cache = new HashMap();

    public  R getInfoWithCache(T id, Function<T,R> consumer){
        R userInfo = cache.get(id);
        if(userInfo != null){
            return userInfo;
        }
        R t1 = consumer.apply(id);
        cache.put(id,t1);
        return t1;
    }
}
