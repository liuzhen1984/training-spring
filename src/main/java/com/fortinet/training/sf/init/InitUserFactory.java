package com.fortinet.training.sf.init;

import com.fortinet.training.sf.instatiation.IUserFactory;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

public class InitUserFactory implements IUserFactory, InitializingBean {

    @PostConstruct
    public void init(){
        System.out.println("@PostConstruct: init method");
    }
    public void initFactoryBean(){
        System.out.println("custom init method");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Implement the afterPropertiesSet() method of  the InitializingBean Interface ");
    }
}
