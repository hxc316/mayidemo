package design.querytype;

import static design.querytype.StatusType.ALL_status;
import static design.querytype.StatusType.CONFIRM_status;
import static design.querytype.TimeType.A_time;
import static design.querytype.TimeType.B_time;

public class SearchParamsFactory {

    private SearchParams searchParams = new SearchParams();

    void build(TimeType type){
        if(type.getCode() .equalsIgnoreCase(A_time.getCode())){
            searchParams.setBeginTime("A_begin");
            searchParams.setEndTime("A_begin");
            return;
        }
        if (type.getCode() .equalsIgnoreCase(B_time.getCode())) {
            searchParams.setBeginTime("B_begin");
            searchParams.setEndTime("B_begin");
            return;
        }
    }

    void build(StatusType statusType){
        if(statusType.getStatus().equalsIgnoreCase(ALL_status.getStatus())){
            searchParams.setStatus("");
            return;
        }
        if(statusType.getStatus().equalsIgnoreCase(CONFIRM_status.getStatus())){
            searchParams.setStatus("CONFIRM");
            return;
        }
    }

    public SearchParams getSearchParams(){
        return searchParams;
    }

}
