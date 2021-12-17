package com.fortinet.training.sf.dependency.injection;

import com.fortinet.training.sf.domian.SuperUser;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

public class AnnotationAwareDependencyInjectionDemo implements BeanFactoryAware, ApplicationContextAware, EnvironmentAware {

    private static BeanFactory beanFactory;
    private static ApplicationContext applicationContext;
    private static Environment environment;

    @Deprecated
    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationAwareDependencyInjectionDemo.class);
        applicationContext.refresh();
        System.out.println(AnnotationAwareDependencyInjectionDemo.beanFactory);
        System.out.println(AnnotationAwareDependencyInjectionDemo.beanFactory==applicationContext.getBeanFactory());
        System.out.println(AnnotationAwareDependencyInjectionDemo.applicationContext);
        System.out.println(AnnotationAwareDependencyInjectionDemo.applicationContext==applicationContext);
        System.out.println(AnnotationAwareDependencyInjectionDemo.environment);

        applicationContext.close();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        AnnotationAwareDependencyInjectionDemo.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        AnnotationAwareDependencyInjectionDemo.applicationContext = applicationContext;
    }

    @Override
    public void setEnvironment(Environment environment) {
        AnnotationAwareDependencyInjectionDemo.environment = environment;
    }
}
