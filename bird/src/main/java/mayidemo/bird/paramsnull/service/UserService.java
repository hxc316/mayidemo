package mayidemo.bird.paramsnull.service;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class UserService {

    public void s1(@NotNull(message = "id为空") Integer id){
        System.out.println(" @NotNull Integer id = " + id);
    }

}
