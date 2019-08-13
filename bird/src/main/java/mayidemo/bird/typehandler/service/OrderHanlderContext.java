package mayidemo.bird.typehandler.service;

import mayidemo.bird.typehandler.OrderDto;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class OrderHanlderContext {

    private final Map<String, OrderService> strategyMap = new ConcurrentHashMap<>();

    public OrderHanlderContext(Map<String,OrderService> strategyMap){
        this.strategyMap.clear();
        strategyMap.forEach((k,v) -> this.strategyMap.put(k,v));
    }

    public void handlerOrder(OrderDto orderDto){
        strategyMap.get(orderDto.getType()).handler(orderDto);
    }
}
