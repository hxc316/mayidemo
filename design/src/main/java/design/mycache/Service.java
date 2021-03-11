package design.mycache;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private Dao dao;

    private UtilV2<Long,UserInfo> utilV2;

    public void mm(){
        UserInfo userInfo = dao.getById(1l);

        List<Long> list = new ArrayList<>();
        list.add(1l);
        list.add(1l);
        list.add(2l);

        for(Long id :list){
            dao.getById(id);
        }
    }

    public void mm22(){
        List<Long> list = new ArrayList<>();
        list.add(1l);
        list.add(1l);
        list.add(2l);

        for(Long id :list){
            utilV2.getInfoWithCache(id,dao::getById);
        }


    }
}
