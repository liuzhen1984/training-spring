package com.fortinet.training.sf.session13;

import com.fortinet.training.sf.domian.User;
import com.fortinet.training.sf.domian.UserCollection;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependencyInjectionDemo {

    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlPath = "classpath:/META-INF/bean-context.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlPath);

        applicationContext.refresh();

        System.out.println(applicationContext.getBean(User.class));
//        System.out.println(applicationContext.getBean(UserCollection.class));

        applicationContext.close();

    }

}
