package design.accountstop;

public class OnlineType extends P_Parent{

    @Override
    public void doDel(Integer accountId) {
        System.out.println("删除账号 accountId = " +accountId + ",type = offline");
    }

    @Override
    public String getAccountType() {
        return "onlineType";
    }

    @Override
    public void doStop(Integer accountId) {
        System.out.println("删除关联关系 accountId = " +accountId + ",type = offline");
    }
}
