package mayidemo.bird.jason;


import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MM {

    @JSONField(name = "name_xx")
    private String name;
    @JSONField(serialzeFeatures = SerializerFeature.WriteNullNumberAsZero)
    private Integer id;
    private String sex;
}
