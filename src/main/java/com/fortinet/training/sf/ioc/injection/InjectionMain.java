package com.fortinet.training.sf.ioc.injection;

import com.fortinet.training.sf.ioc.repositry.UserDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class InjectionMain {
    public static void main(String[] args){
        //step 1
//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        //step 2
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");


        System.out.println(applicationContext.getBean("userDao"));


        // internal bean  => lookup and injection source are different
       UserDao userDao =  applicationContext.getBean("userDao",UserDao.class);
//       iocContainer(userDao,beanFactory);
       iocContainer(userDao,applicationContext);

    }

//    private static void iocContainer(UserDao userDao,BeanFactory beanFactory){
    private static void iocContainer(UserDao userDao,ApplicationContext applicationContext){
        System.out.println(userDao.getBeanFactory()==applicationContext);
        System.out.println(userDao.getBeanFactory());
        System.out.println(applicationContext);
    }

}
