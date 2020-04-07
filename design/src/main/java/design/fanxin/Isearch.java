package design.fanxin;

import java.util.List;

public interface Isearch <T,Q>{


    List<T> search(Q q);
}
