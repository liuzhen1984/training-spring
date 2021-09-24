package com.fortinet.training.sf.gc;

import com.fortinet.training.sf.destory.DestoryUserFactory;
import com.fortinet.training.sf.instatiation.IUserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanGarbageCollectionDemo {
    public static void main(String[] args) throws InterruptedException {
        //Implementation by annotation
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanGarbageCollectionDemo.class);
        applicationContext.refresh();
        applicationContext.close();

        Thread.sleep(5000L);
        System.gc();
        Thread.sleep(5000L);

        //Implementation by xml
//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/bean-init-context.xml");
//        IUserFactory userFactory2 = beanFactory.getBean(InitUserFactory.class);
    }

    @Bean(initMethod = "initFactoryBean",destroyMethod = "customDestroy")
    public GCUserFactory userFactoryBean(){
        return new GCUserFactory();
    }
}
