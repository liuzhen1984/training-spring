package com.fortinet.training.sf.init;

import com.fortinet.training.sf.instatiation.IUserFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@Configuration
public class BeanInitializationDemo {
    public static void main(String[] args){
        //Implementation by annotation
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInitializationDemo.class);
        applicationContext.refresh();
        IUserFactory userFactory = applicationContext.getBean(IUserFactory.class);
        applicationContext.close();

//        Implementation by xml
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/bean-init-context.xml");
        IUserFactory userFactory2 = beanFactory.getBean(InitUserFactory.class);
    }

    @Bean(name = "annotationUserFactory",initMethod = "initFactoryBean")
    public InitUserFactory userFactoryBean(){
        return new InitUserFactory();
    }
}
