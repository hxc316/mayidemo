package design.m;

import java.util.List;

public class AccountContext {

    List<A> aList;

    public void sun(){
        Integer userId = 1;
        Long sum = 0l;
        for(A a :aList){
            sum += a.s(userId);
        }
    }



}
