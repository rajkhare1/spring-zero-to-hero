package com.example.beans;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {

    public Vehicle() {
        System.out.println("Vehicle bean is created by Spring");
    }

    private String name;

    @PostConstruct
    public void initialize() {
        this.name= "Toyota";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printHello() {
        System.out.println("Printing Hello from Component Vehicle Bean");
    }

    @Override
    public String toString() {
        return "Vehicle name is - "+name;
    }
}
