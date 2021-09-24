package com.fortinet.training.sf.bean;

import com.fortinet.training.sf.domian.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;

//3. by using import to load
public class JavaAPIBeanDefinitionDemo1 {
    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //registry a config class
        applicationContext.register(JavaAPIBeanDefinitionDemo1.class);
        applicationContext.refresh();
        Map<String,Object> userMap = new HashMap<>();
        userMap.put("id",123L);
        userMap.put("name","naming");
//        registryBeanDefinitionByNaming(applicationContext,User.class,"user-liuzhen",userMap);
//        System.out.println(applicationContext.getBean("user-liuzhen"));
        userMap.put("name","non-naming");
        registryBeanDefinitionByNonnaming(applicationContext,User.class,userMap);
        System.out.println("User all type beans: "+applicationContext.getBeansOfType(User.class));

        //User all type beans: {user=User{id=123, name='naming'}, com.fortinet.training.sf.ioc.domian.User#0=User{id=123, name='non-naming'}}
        applicationContext.close();
    }

    //By naming
    public static void registryBeanDefinitionByNaming(BeanDefinitionRegistry registry, Class<?> beanClass, String beanName, Map<String,Object> value){
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(beanClass);
        for (Map.Entry<String,Object> v:value.entrySet()){
            beanDefinitionBuilder.addPropertyValue(v.getKey(),v.getValue());
        }
        registry.registerBeanDefinition(beanName,beanDefinitionBuilder.getBeanDefinition());

    }
    //By non-naming
    public static void registryBeanDefinitionByNonnaming(BeanDefinitionRegistry registry,Class<?> beanClass, Map<String,Object> value){
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(beanClass);
        for (Map.Entry<String,Object> v:value.entrySet()){
            beanDefinitionBuilder.addPropertyValue(v.getKey(),v.getValue());
        }

        BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(),registry);
    }

}
