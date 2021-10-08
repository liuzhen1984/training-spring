package com.fortinet.training.sf.dependencylookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class ObjectProviderDemo {
    public static void main(String[] args){
        //Implementation by annotation
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ObjectProviderDemo.class);
        applicationContext.refresh();
        lookupByProvider(applicationContext);
        applicationContext.close();

    }
    private static void lookupByProvider(AnnotationConfigApplicationContext applicationContext){
        ObjectProvider<String> string = applicationContext.getBeanProvider(String.class);
        System.out.println(string.getObject());
    }

    @Bean
    public String helloWorld(){
        return "Hello";
    }

}
