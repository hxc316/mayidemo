package design.mycache;

import java.util.HashMap;

public class Util<T> {

    private Dao dao = new Dao();
    private HashMap<Long,UserInfo> cache = new HashMap();

    public UserInfo getUserInfo(Long id){
        UserInfo userInfo = cache.get(id);
        if(userInfo != null){
            return userInfo;
        }
        UserInfo t = dao.getById(1l);
        cache.put(t.getId(),t);
        return t;
    }
}
