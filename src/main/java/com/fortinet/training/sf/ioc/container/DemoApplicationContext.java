package com.fortinet.training.sf.ioc.container;

import com.fortinet.training.sf.ioc.container.AnnotationAppContextIoCContainerDemo;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoApplicationContext extends AnnotationConfigApplicationContext {

    @Override
    protected void onClose() {
        // For subclasses: do nothing by default.
        System.out.println("this application context is closed");
    }

    @Override
    protected void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        System.out.println("this application context is initializing");
    }
}

