package com.fortinet.training.sf.dependencylookup;

import com.fortinet.training.sf.domian.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class ObjectProviderDemo {
    public static void main(String[] args){
        //Implementation by annotation
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ObjectProviderDemo.class);
        applicationContext.refresh();
        lookupByProvider(applicationContext);
        lookupByProviderUser(applicationContext);
        lookupByStreamUser(applicationContext);
        applicationContext.close();

    }
    private static void lookupByProvider(AnnotationConfigApplicationContext applicationContext){
        ObjectProvider<String> string = applicationContext.getBeanProvider(String.class);
        System.out.println(string.getObject());
    }
    private static void lookupByProviderUser(AnnotationConfigApplicationContext applicationContext){
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        System.out.println(userObjectProvider.getIfAvailable(User::createUser));
    }
    private static void lookupByStreamUser(AnnotationConfigApplicationContext applicationContext){
        ObjectProvider<String> strings = applicationContext.getBeanProvider(String.class);
        for(String string:strings){
            System.out.println(string);
        }
//        strings.stream().forEach(System.out::println);
    }

    @Bean
    @Primary
    public String helloWorld(){
        return "Hello";
    }

    @Bean
    public String message(){
        return "Message";
    }

}
