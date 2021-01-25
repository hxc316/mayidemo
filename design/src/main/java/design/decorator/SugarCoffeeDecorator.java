package design.decorator;

public class SugarCoffeeDecorator extends CoffeeDecorator {
    public SugarCoffeeDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getName() {
        return "糖," + super.getName();
    }

    @Override
    public double getPrice() {
        return 0.5 + super.getPrice();
    }
}
