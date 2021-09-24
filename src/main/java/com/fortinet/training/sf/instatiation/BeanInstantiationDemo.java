package com.fortinet.training.sf.instatiation;

import com.fortinet.training.sf.domian.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanInstantiationDemo {
    public static void main(String[] args){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/bean-instantiation-context.xml");
        // 1. static method
        User user = beanFactory.getBean("user-by-static-method", User.class);
        // 2.   <!--bean instance method-->
        User userByInstanceMethod = beanFactory.getBean("user-by-instance-method", User.class);

        // 3. factory bean
        User userByFactoryBean = beanFactory.getBean("user-by-factory-bean",User.class);
        System.out.println(user);
        System.out.println(userByInstanceMethod);
        System.out.println(userByFactoryBean);

    }
}
