package com.fortinet.training.sf.ioc.injection;

import com.fortinet.training.sf.ioc.repositry.UserDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;


public class InjectionMain {
    public static void main(String[] args){
        //step 1
//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        //step 2
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");


        System.out.println(applicationContext.getBean("userDao"));


        // internal bean  => lookup and injection source are different
       UserDao userDao =  applicationContext.getBean("userDao",UserDao.class);
//       iocContainer(userDao,beanFactory);
       iocContainer(userDao,applicationContext);

       System.out.println(new Date().toGMTString());
       synchronized (userDao){
           try {
               userDao.wait(10000L);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println(new Date().toGMTString());

       }

    }

//    private static void iocContainer(UserDao userDao,BeanFactory beanFactory){
    private static void iocContainer(UserDao userDao,ClassPathXmlApplicationContext applicationContext){
        System.out.println(userDao.getBeanFactory()==applicationContext);
        System.out.println(userDao.getBeanFactory());
        System.out.println(applicationContext.getBeanFactory());
    }

}
