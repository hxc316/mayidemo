package mayidemo.bird.jason;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;

public class FastJson2 {

    @Test
    public void test2(){
        MM mm = new MM("aa",null,null);
        String s = JSON.toJSONString(mm, SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.QuoteFieldNames,SerializerFeature.PrettyFormat);
        System.out.println(s);
    }

    @Test
    public void test3(){
        MM mm = new MM("aa",2,null);
        String s = JSON.toJSONString(mm);
        System.out.println(s);
    }
}
