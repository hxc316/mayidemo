package mayidemo.bird.java8;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

public class T2 {

    @Test
    public void test1(){
        ArrayList<Integer> s = Lists.newArrayList(1,2,3);
        Optional<Integer> reduce = s.stream().reduce(Integer::sum);
        System.out.println(reduce.get());
        System.out.println("--------------------------------------------");
        Optional<Integer> sum = s.parallelStream().reduce(Integer::sum);
        System.out.println(sum.get());
    }

    @Test
    public void test2(){
        Stream.iterate(0,t -> t+2).limit(100).forEach(System.out::println);
        Date date = new Date();
//        Stream.iterate(date,d -> DateUtils.addDays(d,1)).limit(10).forEach(item ->{
//            System.out.println(SimpleDateFormat.);
//        });
    }

    @Test
    public void test3(){
        ArrayList<String> list = Lists.newArrayList("abc", "efg", "hij");
//        list.stream.map(T2::mm);
//        Stream<Stream<String>> streamStream = list.stream().map(T2::mm);
        list.stream().flatMap( T2::mm).forEach(System.out::println);

        list.stream().forEach(T2::mm);
    }

    private static Stream<Character> mm(String str){
        ArrayList<Character> xx = Lists.newArrayList();
        for(Character c:str.toCharArray()){
            xx.add(c);
        }
        return xx.stream();
//        char[] chars = str.toCharArray();
//        Stream<String> stringStream = Lists.newArrayList(str.toCharArray()).stream().map(c -> String.valueOf(c));
//        stringStream.forEach(System.out::println);
//        return stringStream;
    }

    @Test
    public void test4(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);
    }

}
