package design.querytype;

public enum StatusType {

    ALL_status("all"),
    CONFIRM_status("confirm");

    private String status;

    StatusType(String code){
        this.status = code;
    }

    public static StatusType getStatusType(String status){
        for(StatusType statusType : StatusType.values()){
            if(statusType.status.equalsIgnoreCase(status)){
                return statusType;
            }
        }
        return null;
    }

    public String getStatus(){
        return this.status;
    }
}
