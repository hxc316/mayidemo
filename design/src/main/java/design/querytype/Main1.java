package design.querytype;

public class Main1 {

    private SearchParamsFactory searchParamsFactory = new SearchParamsFactory();

    public void search(String timeType,String statusType){
        TimeType timeEnum = TimeType.getType(timeType);
        StatusType statusEnum = StatusType.getStatusType(statusType);
        searchParamsFactory.build(timeEnum);
        searchParamsFactory.build(statusEnum);
        SearchParams searchParams = searchParamsFactory.getSearchParams();
    }
}
