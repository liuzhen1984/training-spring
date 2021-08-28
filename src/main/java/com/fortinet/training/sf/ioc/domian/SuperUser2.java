package com.fortinet.training.sf.ioc.domian;

import com.fortinet.training.sf.ioc.annotation.Super;

@Super
public class SuperUser2 extends User{
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SuperUser2{" +
                "age='" + age + '\'' +
                "} " + super.toString();
    }
}
