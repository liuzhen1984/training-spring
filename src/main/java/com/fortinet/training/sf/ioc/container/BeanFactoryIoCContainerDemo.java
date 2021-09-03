package com.fortinet.training.sf.ioc.container;

import com.fortinet.training.sf.ioc.domian.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

public class BeanFactoryIoCContainerDemo {
    public static void main(String[] args){
        // step 1
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
//        String location = "classpath:/META-INF/dependency-injection-context.xml";
//        int beanCount = reader.loadBeanDefinitions(location);
//        System.out.println("bean count = "+beanCount);

        //step 2
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:/META-INF/dependency-injection-context.xml";
        int beanCount = reader.loadBeanDefinitions(location);
        System.out.println("bean count = "+beanCount);
        lookupByCollectionType(beanFactory);

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
