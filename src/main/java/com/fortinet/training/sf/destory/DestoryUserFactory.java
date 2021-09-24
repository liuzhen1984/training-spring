package com.fortinet.training.sf.destory;

import com.fortinet.training.sf.instatiation.IUserFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class DestoryUserFactory implements IUserFactory, InitializingBean, DisposableBean {

    @PostConstruct
    public void init(){
        System.out.println("@PostConstruct: init method");
    }
    public void initFactoryBean(){
        System.out.println("custom init method");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Implement the afterPropertiesSet() method of  the InitializingBean Interface  ");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("@PreDestroy: destroy method");
    }

    public void customDestroy(){
        System.out.println("custom destroy method");
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("Implement the destroy() method of the DisposableBean interface ");


    }


}
