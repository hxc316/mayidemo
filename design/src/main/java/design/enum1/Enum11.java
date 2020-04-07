package design.enum1;

public enum  Enum11 {

    A1("1");

    String s;
    private Enum11(String s){
        this.s = s;
    }

    public String doGet(){
        if("1".equalsIgnoreCase(s)){
            throw new RuntimeException();
        }
        return this.s + "[data]";
    }
}
