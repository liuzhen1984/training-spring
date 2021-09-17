package com.fortinet.training.sf.bean;

import com.fortinet.training.sf.ioc.domian.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

//3. by using import to load
public class AnnotationBeanDefinitionDemo1 {
    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //registry a config class
        applicationContext.register(Config.class);
        applicationContext.refresh();
        System.out.println(applicationContext.getBean("user"));
        System.out.println(applicationContext.getBean("testUser"));
        applicationContext.close();
    }
    //2. By using component
    public static class Config{
        //1. By using bean to define a bean
        @Bean(name={"user","testUser"})
        public User user(){
            User user = new User();
            user.setId(123l);
            user.setName("config");
            return user;

        }
    }
}
