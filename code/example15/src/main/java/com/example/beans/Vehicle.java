package com.example.beans;

import com.example.services.VehicleServices;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("vehicleBean")
public class Vehicle {

    private String name;

    private final VehicleServices vehicleServices;

    @Autowired
    public Vehicle(VehicleServices vehicleService) {
        this.vehicleServices = vehicleService;
    }

    public VehicleServices getVehicleServices() {
        return vehicleServices;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void initialize() {
        this.name = "Honda";
    }

    public void printHello() {
        System.out.println("Printing Hello from Component Vehicle Bean");
    }

    @Override
    public String toString() {
        return "Vehicle name is - "+name;
    }
}
