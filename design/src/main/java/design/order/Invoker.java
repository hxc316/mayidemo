package design.order;

public class Invoker {

    private Commond commond;

    public void setCommond(Commond commond) {
        this.commond = commond;
    }

    public void action(){
        this.commond.execute();
    }

}
