package design.order;

public class Client {

    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        invoker.setCommond(new LockCommand());
        invoker.action();
    }
}
