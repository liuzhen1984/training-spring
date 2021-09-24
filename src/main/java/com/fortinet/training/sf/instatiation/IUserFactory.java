package com.fortinet.training.sf.instatiation;

import com.fortinet.training.sf.domian.User;

public interface IUserFactory {
    default User createUser(){
        return User.createUser();
    }
}
