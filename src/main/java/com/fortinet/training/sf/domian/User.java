package com.fortinet.training.sf.domian;

import org.springframework.core.io.Resource;

public class User {
    private Long id;
    private String name;

    private City city;

    private Resource resource;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                ", resource=" + resource +
                '}';
    }

    public static User createUser(){
        User user= new User();
        user.setId(1l);
        user.setName("user instance");
        return user;
    }
}
