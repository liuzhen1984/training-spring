package com.fortinet.training.sf.domian;

import java.util.Arrays;
import java.util.List;

public class UserCollection {
    private Long id;
    private String name;

    private City city;
    private City[] workCities;
    private List<City> LifeCities;

//    private Resource resource;

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

    public City[] getWorkCities() {
        return workCities;
    }

    public void setWorkCities(City[] workCities) {
        this.workCities = workCities;
    }

    public List<City> getLifeCities() {
        return LifeCities;
    }

    public void setLifeCities(List<City> lifeCities) {
        LifeCities = lifeCities;
    }

    @Override
    public String toString() {
        return "UserCollection{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                ", workCities=" + Arrays.toString(workCities) +
                ", LifeCities=" + LifeCities +
                '}';
    }

    public static UserCollection createUser(){
        UserCollection user= new UserCollection();
        user.setId(1l);
        user.setName("user instance");
        return user;
    }
}
