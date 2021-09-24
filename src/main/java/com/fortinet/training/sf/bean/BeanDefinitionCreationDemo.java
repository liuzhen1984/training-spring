package com.fortinet.training.sf.bean;

import com.fortinet.training.sf.domian.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class BeanDefinitionCreationDemo {
    public static void main(String[] args) {
        //1. BeanDefinitionBuilder
        BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        //properties setting
        definitionBuilder.addPropertyValue("name","zhen");
        definitionBuilder.addPropertyValue("id",1);

        //get instance by BeanDefinition  .return abstract beanDefinition
        BeanDefinition beanDefinition = definitionBuilder.getBeanDefinition();

        //2. By having create abstract bean definition class or implementor
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("id",1).add("name","zhen liu");
        genericBeanDefinition.setPropertyValues(propertyValues);

    }
}
