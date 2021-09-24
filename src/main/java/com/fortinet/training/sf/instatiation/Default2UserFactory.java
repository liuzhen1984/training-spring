package com.fortinet.training.sf.instatiation;

import com.fortinet.training.sf.domian.User;

public class Default2UserFactory implements IUserFactory {
    @Override
    public User createUser(){
        User user= new User();
        user.setId(1l);
        user.setName("user default2");
        return user;
    }

}
