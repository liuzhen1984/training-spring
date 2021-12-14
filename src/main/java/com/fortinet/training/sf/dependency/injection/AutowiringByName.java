package com.fortinet.training.sf.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class AutowiringByName {

    public static void main(String[] args){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String xmlPath = "classpath:/META-INF/bean-dj-autowiring-byname-context.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlPath);
        System.out.println(beanFactory.getBean(UserHandler.class));
    }
}
