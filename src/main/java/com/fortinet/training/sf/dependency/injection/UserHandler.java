package com.fortinet.training.sf.dependency.injection;

import com.fortinet.training.sf.domian.SuperUser;
import com.fortinet.training.sf.domian.User;

public class UserHandler {
    private User user;

    public UserHandler(){}
    public UserHandler(User user){
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserHandler{" +
                "user=" + user +
                '}';
    }
}
