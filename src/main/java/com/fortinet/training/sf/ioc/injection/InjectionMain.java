package com.fortinet.training.sf.ioc.injection;

import com.fortinet.training.sf.ioc.repositry.UserDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class InjectionMain {
    public static void main(String[] args){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        System.out.println(beanFactory.getBean("userDao"));


        // internal bean  => lookup and injection source are different
       UserDao userDao =  beanFactory.getBean("userDao",UserDao.class);
       System.out.println(userDao.getBeanFactory());
       System.out.println(beanFactory);
//       System.out.println(userDao.getBeanFactory()==beanFactory);


//       //?
       System.out.println(userDao.getObjectFactory().getObject());
//
//       System.out.println(userDao.getApplicationContextObjectFactory().getObject());


    }

}
