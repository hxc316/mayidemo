package design.decorator;

public abstract class CoffeeDecorator implements Coffee {

    private Coffee coffee;

    public CoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }

    @Override
    public String getName() {
        return coffee.getName();
    }

    @Override
    public double getPrice() {
        return coffee.getPrice();
    }
}
