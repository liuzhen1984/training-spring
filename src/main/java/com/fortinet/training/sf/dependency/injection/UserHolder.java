package com.fortinet.training.sf.dependency.injection;

import com.fortinet.training.sf.domian.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserHolder {
    private User user;

    public UserHolder(){}
    @Autowired
    public UserHolder(User user){
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
