package design.accountstop;

public abstract class P_Parent implements P{

    @Override
    public void stop(Integer accountId) {
        delRefer(accountId);
        doStop(accountId);
    }

    @Override
    public void del(Integer accountId) {
        delRefer(accountId);
        doDel(accountId);
    }

    public void delRefer(Integer accountId){
            System.out.println("删除关联关系 id = " + accountId + "account type = " + getAccountType());
    }

    public abstract void doDel(Integer accountId);

    public abstract String getAccountType();

    public abstract void doStop(Integer accountId);
}
