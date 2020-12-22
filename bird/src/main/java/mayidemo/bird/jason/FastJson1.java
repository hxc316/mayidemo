package mayidemo.bird.jason;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class FastJson1 {


    public static void main(String[] args) {
        MM mm = new MM("xiaoming",1,"F");
        String s = JSON.toJSONString(mm, SerializerFeature.UseSingleQuotes);
        System.out.println(s);
    }

    
}
