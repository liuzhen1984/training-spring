package com.fortinet.training.sf.javabeans;


import java.beans.*;
import java.util.stream.Stream;

public class BeanInfoDemo {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class,Object.class);

        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertryDescriptor -> {
            System.out.println(propertryDescriptor);
        });
        System.out.println("==================");

        beanInfo = Introspector.getBeanInfo(Person.class,Object.class); //baseclasses

        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertryDescriptor -> {
            //PropertyDescriptior allow to add attribute editor
            //String=> Integer
            System.out.println(propertryDescriptor);
            Class<?> propertryType = propertryDescriptor.getPropertyType();
            String propertyName = propertryDescriptor.getName();
            if("age".equals(propertyName)){
                //String->Integer
                propertryDescriptor.setPropertyEditorClass(StringToIntegerEditor.class);
//                propertryDescriptor.createPropertyEditor()
            }
        });



    }

    static class StringToIntegerEditor extends PropertyEditorSupport {

        @Override
        public void setAsText(String text){
            setValue(Integer.valueOf(text));
        }

    }
}
