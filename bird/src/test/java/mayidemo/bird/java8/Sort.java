package mayidemo.bird.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sort {

    @Data
    @AllArgsConstructor
    class Ms {
        private Integer id;
        private String name;


    }

    @Test
    public void test1(){
        ArrayList<Ms> list = new ArrayList();
        list.add(new Ms(1,"1"));
        list.add(new Ms(3,"3"));
        list.add(new Ms(2,"2"));
        list.add(new Ms(4,"2"));

        List<Ms> collect = list.stream().sorted(Comparator.comparing(Ms::getName).thenComparing(Ms::getId)).collect(Collectors.toList());

        collect.stream().forEach(i -> System.out.println(i.getId()));

    }
}
