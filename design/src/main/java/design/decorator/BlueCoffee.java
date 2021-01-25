package design.decorator;

public class BlueCoffee implements Coffee{
    @Override
    public String getName() {
        return "蓝莓咖啡";
    }

    @Override
    public double getPrice() {
        return 15;
    }
}
