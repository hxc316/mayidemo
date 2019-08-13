package mayidemo.bird.typehandler;

import mayidemo.bird.BirdApplicationTests;
import mayidemo.bird.typehandler.service.OrderHanlderContext;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderHandlerContextTest extends BirdApplicationTests {

    @Autowired
    OrderHanlderContext orderHanlderContext;

    @Test
    public void test1(){

        OrderDto order = new OrderDto("B","code001");

        orderHanlderContext.handlerOrder(order);
    }
}
