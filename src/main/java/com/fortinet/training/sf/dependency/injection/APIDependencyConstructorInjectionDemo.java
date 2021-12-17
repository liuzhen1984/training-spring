package com.fortinet.training.sf.dependency.injection;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class APIDependencyConstructorInjectionDemo {

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
        definitionBuilder.addConstructorArgReference("superUser");
//        definitionBuilder.addConstructorArgReference("user");
        return definitionBuilder.getBeanDefinition();
    }

}
