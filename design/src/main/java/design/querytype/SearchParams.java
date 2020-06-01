package design.querytype;

import lombok.Data;

@Data
public class SearchParams {

    private String beginTime;
    private String endTime;

    private String status;

}
