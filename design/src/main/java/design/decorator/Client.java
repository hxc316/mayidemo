package design.decorator;

public class Client {


    public static void main(String[] args) {
        Coffee coffee = new BlueCoffee();

        System.out.println(coffee.getName() + " : " + coffee.getPrice());

        coffee = new MilkCoffeeDecorator(coffee);
        System.out.println(coffee.getName() + " : " + coffee.getPrice());

        coffee = new SugarCoffeeDecorator(coffee);
        System.out.println(coffee.getName() + " : " + coffee.getPrice());
    }
}
