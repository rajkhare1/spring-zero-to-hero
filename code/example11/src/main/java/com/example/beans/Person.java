package com.example.beans;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private String name;

    /*
    The @Autowired annotation marks on a field, constructor, Setter method
    is used to auto-wire the beans that is 'injecting beans' (Objects) at runtime
    by Spring Dependency Injection mechanism

    * */

    /*@Autowired*/
    /*private Vehicle vehicle;*/
    private final Vehicle vehicle;

    /*@Autowired*/ // since Spring version 4.3, if only 1 constructor, then this is optional
    public Person(Vehicle vehicle) {
        System.out.println("Person bean created by Spring");
        this.vehicle = vehicle;
    }

    @PostConstruct
    public void initialize() {
        this.name = "Lucy";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    /*@Autowired*/
    /*public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }*/
}
