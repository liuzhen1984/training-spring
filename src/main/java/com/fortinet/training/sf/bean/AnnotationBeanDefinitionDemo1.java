package com.fortinet.training.sf.bean;

import com.fortinet.training.sf.domian.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

//3. by using import to load
public class AnnotationBeanDefinitionDemo1 {
    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //registry a config class
        applicationContext.register(Config.class);
        applicationContext.refresh();
        System.out.println(applicationContext.getBean("user"));
        System.out.println(applicationContext.getBean("testUser"));
        System.out.println(applicationContext.getBean("user2"));
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
        @Bean(name={"user2","testUser2"})
        public User user2(){
            User user = new User();
            user.setId(123l);
            user.setName("config2");
            return user;

        }
    }
    public static class Config2{
        //1. By using bean to define a bean
        @Bean(name={"user2","testUser2"})
        public User user(){
            User user = new User();
            user.setId(123l);
            user.setName("config");
            return user;

        }
    }
}
