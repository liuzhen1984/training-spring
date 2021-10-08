package com.fortinet.training.sf.init;

import com.fortinet.training.sf.instatiation.IUserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;


@Configuration
public class BeanLazyInitializationDemo {
    public static void main(String[] args){
        //Implementation by annotation
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanLazyInitializationDemo.class);
        applicationContext.refresh();
        System.out.println("Sprig application context has started...");
        IUserFactory userFactory = applicationContext.getBean(IUserFactory.class);
        applicationContext.close();


    }

    @Bean(name = "annotationUserFactory",initMethod = "initFactoryBean")
    @Lazy(value = false)
//    @Lazy
    public InitUserFactory userFactoryBean(){
        return new InitUserFactory();
    }
}
