package com.fortinet.training.sf.dependency.injection;

import com.fortinet.training.sf.domian.SuperUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

public class AnnotationConstructorDependencyInjectionDemo {


    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlPath = "classpath:/META-INF/bean-context.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlPath);
        applicationContext.register(AnnotationConstructorDependencyInjectionDemo.class);
        applicationContext.register(UserHolder.class);
        applicationContext.refresh();

        AnnotationConstructorDependencyInjectionDemo demo = applicationContext.getBean(AnnotationConstructorDependencyInjectionDemo.class);
        ;

        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println(userHolder.getUser());

        applicationContext.close();

    }

    @Bean
    public UserHandler userHandler(SuperUser user){
        return new UserHandler(user);
    }

}
