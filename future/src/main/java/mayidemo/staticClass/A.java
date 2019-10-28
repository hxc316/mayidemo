package mayidemo.staticClass;

import lombok.Data;

public class A {

    private Integer sum = 0;
    private static Object o = new Object();
    public void s(M m){
        Integer n = m.getNum();
        synchronized (o){
            sum += n;
        }
    }

    public Integer getSum(){
        return sum;
    }

    @Data
    static class M{

        public M(){

        }

        Integer num;
    }

}
