package design.valid;

import design.valid.dto.User;

public class AccountService {

    IV iv = new ValidAccount();

    public void add(){
        User user = new User();
        iv.validAdd(user);
    }
}
