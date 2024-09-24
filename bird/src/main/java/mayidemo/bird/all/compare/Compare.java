package mayidemo.bird.all.compare;

import com.google.common.collect.Lists;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.TransformerUtils;
import org.apache.commons.collections.comparators.FixedOrderComparator;
import org.apache.commons.collections.comparators.TransformingComparator;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author huxinchao
 * @ClassName A1.java
 * @Description TODO
 * @createTime 2024年09月24日 14:13:00
 */
public class Compare {

    public static void main(String[] args) {
        ArrayList<GameName> list = Lists.newArrayList();
        GameName c1 = new GameName();
        c1.setProductId("WZRY");
        list.add(c1);

        GameName c2 = new GameName();
        c2.setProductId("HEIWUKONG");
        list.add(c2);

        GameName c3 = new GameName();
        c3.setProductId("PAOPAO");
        list.add(c3);

//        Collections.sort();
        FixedOrderComparator fixedOrder = new FixedOrderComparator(new String[]{"HEIWUKONG","WZRY","PAOPAO"});
        Transformer getProductId = TransformerUtils.invokerTransformer("getProductId");
        TransformingComparator tc = new TransformingComparator(getProductId,fixedOrder);
        Collections.sort(list,tc);
        for (GameName o : list) {
            System.out.println(o.getProductId());
        }

    }
}
