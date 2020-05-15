package mayidemo.bird.java8.mm;

public class A1 {

    public static void main(String[] args) {
//        String s = "1";
        Say say = s -> s + "world";
        System.out.println(say.hello(" jeremy"));
    }
}
