package com.fortinet.training.sf.bean;

import com.fortinet.training.sf.domian.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
//3. by using import to load
@Import(AnnotationBeanDefinitionDemo2.Config.class)
public class AnnotationBeanDefinitionDemo2 {
    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //registry a config class
        applicationContext.register(AnnotationBeanDefinitionDemo2.class);
        applicationContext.refresh();
        System.out.println(applicationContext.getBean("user"));
        System.out.println(applicationContext.getBean("config"));

        System.out.println("Config all type beans: "+applicationContext.getBeansOfType(Config.class));
        System.out.println("User all type beans: "+applicationContext.getBeansOfType(User.class));
        applicationContext.close();
    }
    //2. By using component
    @Component(value = "config")
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
