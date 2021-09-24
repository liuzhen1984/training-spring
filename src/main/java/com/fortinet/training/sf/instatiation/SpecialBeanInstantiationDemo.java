package com.fortinet.training.sf.instatiation;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SpecialBeanInstantiationDemo {
    public static void main(String[] args){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/bean-special-instantiation-context.xml");

       //1.
        demoServiceLoader();

        //2.
        ServiceLoader<IUserFactory> serviceLoader = beanFactory.getBean("user-factory-service-load",ServiceLoader.class);
        display(serviceLoader);

        //3
//        IUserFactory userFactory = beanFactory.getBean("user-factory-service",IUserFactory.class);
//        System.out.println(userFactory.createUser());
    }

    public static void demoServiceLoader(){
        ServiceLoader<IUserFactory> serviceLoader = ServiceLoader.load(IUserFactory.class,Thread.currentThread().getContextClassLoader());
        display(serviceLoader);
    }

    public static void display(ServiceLoader<IUserFactory> serviceLoader){
        Iterator<IUserFactory> iUserFactoryIterator=serviceLoader.iterator();
        while (iUserFactoryIterator.hasNext()){
            IUserFactory userFactory = iUserFactoryIterator.next();
            System.out.println(userFactory.createUser());
        }
    }
}
