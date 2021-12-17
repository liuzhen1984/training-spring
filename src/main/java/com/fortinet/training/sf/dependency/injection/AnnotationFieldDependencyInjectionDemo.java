package com.fortinet.training.sf.dependency.injection;

import com.fortinet.training.sf.domian.SuperUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

public class AnnotationFieldDependencyInjectionDemo {

    @Autowired
    private UserHandler userHandler;
//    private static UserHandler userHandler;

    @Resource
    private UserHandler userHandler2;

    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlPath = "classpath:/META-INF/bean-context.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlPath);
        applicationContext.register(AnnotationFieldDependencyInjectionDemo.class);
        applicationContext.refresh();

        AnnotationFieldDependencyInjectionDemo demo = applicationContext.getBean(AnnotationFieldDependencyInjectionDemo.class);
        ;

        System.out.println(demo.userHandler);
        System.out.println(demo.userHandler2);
        System.out.println(demo.userHandler2 == demo.userHandler);


        applicationContext.close();

    }

    @Bean
    public UserHandler userHandler(SuperUser user){
        return new UserHandler(user);
    }
}
