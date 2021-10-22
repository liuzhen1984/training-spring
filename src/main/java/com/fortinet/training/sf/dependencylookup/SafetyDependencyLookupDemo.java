package com.fortinet.training.sf.dependencylookup;

import com.fortinet.training.sf.domian.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class SafetyDependencyLookupDemo {
    public static void main(String[] args){
        //Implementation by annotation
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ObjectProviderDemo.class);
        applicationContext.refresh();
        displayBeanFactoryGetBean(applicationContext);
        displayObjectFactoryGetObject(applicationContext);
        displayObjectProviderIfAvailable(applicationContext);
        displayListableBeanFactoryGetBeansOfType(applicationContext);
        displayListableBeanFactoryStreamOps(applicationContext);
        applicationContext.close();

    }
    private static void displayListableBeanFactoryStreamOps(AnnotationConfigApplicationContext applicationContext){
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);

        printException("displayListableBeanFactoryStreamOps",()->objectProvider.forEach(System.out::println));
    }
    private static void displayListableBeanFactoryGetBeansOfType(ListableBeanFactory beanFactory){
        printException("displayListableBeanFactoryGetBeansOfType",()->beanFactory.getBeansOfType(User.class));
    }
    private static void displayObjectProviderIfAvailable(AnnotationConfigApplicationContext applicationContext){
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        printException("displayObjectProviderIfAvailable",()->userObjectProvider.getIfAvailable());
    }
    private static void displayObjectFactoryGetObject(AnnotationConfigApplicationContext applicationContext){
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        printException("displayObjectFactoryGetObject",()->userObjectProvider.getObject(User.class));
    }
    private static void displayBeanFactoryGetBean(BeanFactory beanFactory){
        printException("displayBeanFactoryGetBean",()->beanFactory.getBean(User.class));
//        strings.stream().forEach(System.out::println);
    }

    private static void printException(String source, Runnable runnable){
        System.err.println(" source :"+source);
        try{
            runnable.run();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Bean
    @Primary
    public String helloWorld(){
        return "Hello\n";
    }

    @Bean
    public String message(){
        return "Message\n";
    }
}
