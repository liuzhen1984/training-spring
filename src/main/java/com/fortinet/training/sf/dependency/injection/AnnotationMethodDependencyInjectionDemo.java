package com.fortinet.training.sf.dependency.injection;

import com.fortinet.training.sf.domian.SuperUser;
import com.fortinet.training.sf.domian.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

public class AnnotationMethodDependencyInjectionDemo {

    private UserHandler userHandler;
//    private static UserHandler userHandler;

    private UserHandler userHandler2;

    @Autowired
    private void init(UserHandler userHandler){
        this.userHandler = userHandler;
    }
    @Resource
    private void init2(UserHandler userHandler){
        this.userHandler2 = userHandler;
    }

    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlPath = "classpath:/META-INF/bean-context.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlPath);
        applicationContext.register(AnnotationMethodDependencyInjectionDemo.class);
        applicationContext.refresh();

        AnnotationMethodDependencyInjectionDemo demo = applicationContext.getBean(AnnotationMethodDependencyInjectionDemo.class);
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
