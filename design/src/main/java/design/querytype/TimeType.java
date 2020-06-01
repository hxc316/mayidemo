package design.querytype;

public enum TimeType {

    A_time("a"),
    B_time("b");

    private String code;

    TimeType(String code){
        this.code = code;
    }

    public static TimeType getType(String a){
        for(TimeType type:TimeType.values()){
            if(type.code.equalsIgnoreCase(a)){
                return type;
            }
        }
        return null;
    }

    public String getCode(){
        return code;
    }
}
