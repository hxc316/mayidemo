package design.accountstop;

public class OfflineType extends P_Parent {
    @Override
    public void doDel(Integer accountId) {
        System.out.println("删除账号 accountId = " +accountId + ",type = online");
    }

    @Override
    public String getAccountType() {
        return "offType";
    }

    @Override
    public void doStop(Integer accountId) {
        System.out.println("停用账号 accountId = " +accountId + ",type = online");
    }
}
