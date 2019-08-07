package mayidemo.bird.paramsnull;

import mayidemo.bird.paramsnull.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MService {

    @Autowired
    UserService userService;
    public void m(){
        userService.s1(null);
    }

}
