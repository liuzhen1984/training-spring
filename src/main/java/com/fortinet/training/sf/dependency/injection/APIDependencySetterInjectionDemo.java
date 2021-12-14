package com.fortinet.training.sf.dependency.injection;

import com.fortinet.training.sf.domian.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class APIDependencySetterInjectionDemo {

    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        BeanDefinition userBeanDefinition = createUserHandlerBeanDefinition();
        applicationContext.registerBeanDefinition("userHandler",userBeanDefinition);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String xmlPath = "classpath:/META-INF/bean-context.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlPath);

        applicationContext.refresh();

        System.out.println(applicationContext.getBean(UserHandler.class));

        applicationContext.close();

    }

    private static BeanDefinition createUserHandlerBeanDefinition(){
        BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserHandler.class);
        definitionBuilder.addPropertyReference("user","superUser");
        return definitionBuilder.getBeanDefinition();
    }

}
