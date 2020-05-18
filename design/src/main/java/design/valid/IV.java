package design.valid;

public interface IV<T> {

    void validAdd(T t);

    default void validSiteId(Long siteId){
        if(siteId == null){
            throw new IllegalArgumentException("siteId is null");
        }
    }
}
