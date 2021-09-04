package com.fortinet.training.sf.ioc.container;

import com.fortinet.training.sf.ioc.domian.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

public class AnnotationAppContextIoCContainerDemo {
    public static void main(String[] args){
        // step 1
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//        applicationContext.register(AnnotationAppContextIoCContainerDemo.class);
//        lookupByCollectionType(applicationContext);

        //step2
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        DemoApplicationContext applicationContext = new DemoApplicationContext();
        applicationContext.register(AnnotationAppContextIoCContainerDemo.class);
        //Start application context
        applicationContext.refresh();
        lookupByCollectionType(applicationContext);
//
//        //step 4
        applicationContext.close();

        //step 5
    }

//step3
    @Bean
    public User user(){
        User user = new User();
        user.setId(100l);
        user.setName("casb");
        return user;
    }

    private static void lookupByCollectionType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> map = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("lookupByCollectionType : "+map);
            System.out.println("=============");
        }
    }
}
