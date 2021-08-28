package com.fortinet.training.sf.ioc.lookup;

import com.fortinet.training.sf.ioc.annotation.Super;
import com.fortinet.training.sf.ioc.domian.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class LookupMain {

    public static void main(String[] args){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
        lookupByName(beanFactory);
        lookupByLazyName(beanFactory);
        lookupByType(beanFactory);
        lookupByCollectionType(beanFactory);

        lookupByNameAndType(beanFactory);
        lookupByAnnotation(beanFactory);
    }

    private static void lookupByAnnotation(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String,User> map = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("lookupByAnnotation : "+map);
            System.out.println("=============");


        }
    }

    private static void lookupByNameAndType(BeanFactory beanFactory) {
        System.out.println("lookupByNameAndType: "+beanFactory.getBean("user",User.class));
        System.out.println("=============");

    }

    private static void lookupByCollectionType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String,User> map = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("lookupByCollectionType : "+map);
            System.out.println("=============");
        }
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("lookup by type " + user);
        System.out.println("=============");
    }

    private static void lookupByName(BeanFactory beanFactory){
        System.out.println("lookupByName: " +beanFactory.getBean("user"));
        System.out.println("=============");
    }
    private static void lookupByLazyName(BeanFactory beanFactory){
        System.out.println(beanFactory.getBean("lazyUser"));
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("lazyUser");
        System.out.println("lazy load user : " + objectFactory.getObject());

        System.out.println("=============");
    }
}
