package com.fortinet.training.sf.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HierarchicalDemo {
    public static void main(String[] args){
        //Implementation by annotation
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(HierarchicalDemo.class);

        //1. HierarchicalBeanFactory->ConfigurableBeanFactory->ConfigurableListableBeanFactory
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        System.out.println("parent bean factory "+beanFactory.getParentBeanFactory());

//        //2. set parent beanfactory
        HierarchicalBeanFactory parentBeanFactory= createParentBeanFactory();
        beanFactory.setParentBeanFactory(parentBeanFactory);
        System.out.println("parent bean factory "+beanFactory.getParentBeanFactory());
//
        displayLocalBean(beanFactory,"user");
        displayLocalBean(parentBeanFactory,"user");
        displayContainesBean(beanFactory,"user");

        applicationContext.refresh();

        applicationContext.close();

    }
    private static void displayContainesBean(HierarchicalBeanFactory beanFactory,String beanName) {
        System.out.printf("beanfactory [%s], includes bean[name:%s]: %s\n",beanFactory,beanName,containesBean(beanFactory,beanName));
    }
    private static Boolean containesBean(HierarchicalBeanFactory beanFactory,String beanName){
        BeanFactory parentBeanFactory = beanFactory.getParentBeanFactory();
        if( parentBeanFactory instanceof HierarchicalBeanFactory){
            HierarchicalBeanFactory parentHierachicalBeanFactory = HierarchicalBeanFactory.class.cast(parentBeanFactory);
            if (containesBean(parentHierachicalBeanFactory,beanName)){
                return true;
            }
        }
        return beanFactory.containsLocalBean(beanName);
    }
    private static void displayLocalBean(HierarchicalBeanFactory beanFactory, String beanName){
        System.out.printf("beanfactory [%s], includes bean[name:%s]: %s\n",beanFactory,beanName,beanFactory.containsLocalBean(beanName));
    }

    private static HierarchicalBeanFactory createParentBeanFactory(){
        HierarchicalBeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/bean-instantiation-context.xml");
        return beanFactory;
    }
}
