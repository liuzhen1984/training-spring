package com.fortinet.training.sf.ioc.repositry;

import com.fortinet.training.sf.ioc.domian.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

public class UserDao {
    private Collection<User> user;

    private BeanFactory beanFactory;  // non-bean
    private ObjectFactory<User> objectFactory; //Delay
//    private ObjectFactory<ApplicationContext> applicationContextObjectFactory;

//    public ObjectFactory<ApplicationContext> getApplicationContextObjectFactory() {
//        return applicationContextObjectFactory;
//    }
//
//    public void setApplicationContextObjectFactory(ObjectFactory<ApplicationContext> applicationContextObjectFactory) {
//        this.applicationContextObjectFactory = applicationContextObjectFactory;
//    }
//
    public ObjectFactory<User> getObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory<User> objectFactory) {
        this.objectFactory = objectFactory;
    }
//
    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }


    public Collection<User> getUser() {
        return user;
    }

    public void setUser(Collection<User> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserDao{" +
                "user=" + user +
                '}';
    }
}
