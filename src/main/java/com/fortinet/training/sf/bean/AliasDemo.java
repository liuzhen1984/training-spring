package com.fortinet.training.sf.bean;

import com.fortinet.training.sf.ioc.repositry.UserDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AliasDemo {
    public static void main(String[] args){
        //step 1
//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        //step 2
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");


        System.out.println(applicationContext.getBean("testUser"));
        System.out.println(applicationContext.getBean("user"));
        System.out.println(applicationContext.getBean("user")==applicationContext.getBean("testUser"));



    }


}
