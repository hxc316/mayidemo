package mayidemo.bird.typehandler.service.impl;

import lombok.extern.slf4j.Slf4j;
import mayidemo.bird.typehandler.OrderDto;
import mayidemo.bird.typehandler.service.OrderService;
import org.springframework.stereotype.Component;

@Slf4j
@Component(value = "B")
public class BOrderServiceImpl implements OrderService {
    @Override
    public void handler(OrderDto orderDto) {
      log.info("handler order type = B");
    }
}
