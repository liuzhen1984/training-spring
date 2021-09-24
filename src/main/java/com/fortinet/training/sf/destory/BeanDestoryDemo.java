package com.fortinet.training.sf.destory;

import com.fortinet.training.sf.instatiation.IUserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanDestoryDemo {
    public static void main(String[] args){
        //Implementation by annotation
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanDestoryDemo.class);
        applicationContext.refresh();
        IUserFactory userFactory = applicationContext.getBean(IUserFactory.class);
        applicationContext.close();

        //Implementation by xml
//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/bean-init-context.xml");
//        IUserFactory userFactory2 = beanFactory.getBean(InitUserFactory.class);
    }

    @Bean(initMethod = "initFactoryBean",destroyMethod = "customDestroy")
    public DestoryUserFactory userFactoryBean(){
        return new DestoryUserFactory();
    }
}
