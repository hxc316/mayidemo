package mayidemo.bird.java8.c2;

import java.util.function.Consumer;

public class Person {

    public void buyWater(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.buyWater(2,(m)-> System.out.println("在便利店买水花费" + m +"元"));
    }
}
