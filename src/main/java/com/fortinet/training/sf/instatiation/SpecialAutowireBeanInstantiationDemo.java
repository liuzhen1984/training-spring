package com.fortinet.training.sf.instatiation;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SpecialAutowireBeanInstantiationDemo {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/bean-special-instantiation-context.xml");

        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();
        ServiceLoader<IUserFactory> serviceLoader =  beanFactory.getBean("user-factory-service-load",ServiceLoader.class);
        display(serviceLoader);

        IUserFactory userFactory = beanFactory.createBean(IUserFactory.class);
//        IUserFactory userFactory = beanFactory.createBean(Default2UserFactory.class);
        System.out.println(userFactory.createUser());

    }


    public static void display(ServiceLoader<IUserFactory> serviceLoader){
        Iterator<IUserFactory> iUserFactoryIterator=serviceLoader.iterator();
        while (iUserFactoryIterator.hasNext()){
            IUserFactory userFactory = iUserFactoryIterator.next();
            System.out.println(userFactory.createUser());
        }
    }
}
