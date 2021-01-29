package mayidemo.bird.java8.c3;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Util {

    public static ArrayList<String> mm(ArrayList<String> filterList, Predicate<String> predicate){
        ArrayList<String> list = new ArrayList();
        for(String s :filterList){
            if(predicate.test(s)){
                list.add(s);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("z");
        list.add("g");
        ArrayList<String> filterList = mm(list, (s) -> "h".compareTo(s) > 0);
        filterList.forEach(System.out::println);
    }



}
