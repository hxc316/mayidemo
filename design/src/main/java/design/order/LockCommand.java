package design.order;

public class LockCommand extends Commond{
    @Override
    public void execute() {
        System.out.println("do lock ... ");
    }
}
