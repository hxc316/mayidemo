package design.valid;

import design.valid.dto.User;

public class ValidAccount implements IV<User> {

    @Override
    public void validAdd(User u) {
        validSiteId(u.getSiteId());
        if(u.getId() == null){
            throw new IllegalArgumentException("id is null");
        }
    }

}
