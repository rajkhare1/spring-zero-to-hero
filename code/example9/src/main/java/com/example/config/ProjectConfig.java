package com.example.config;

import com.example.beans.Person;
import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
    Spring @Configuration annotation is part of the spring core framework.
    Spring Configuration annotation indicates that the class has @Bean definition methods.
    So Spring container can process the class generate Spring Beans to be used in the application.
* */
@Configuration
public class ProjectConfig {

    /*
        @Bean annotation, which lets Spring know that it needs to call this method when
        it initializes its context and adds the returned value to the context.
    * */
    @Bean
    public Vehicle vehicle() {
        var veh = new Vehicle();
        veh.setName("Toyota");
        return veh;
    }

    /*
        Here in below code, we are trying to wire or establish a relationship between Person and
        Vehicle, by invoking the vehicle() bean method from person() bean method.

        Spring will make sure to have only 1 vehicle bean is created and also vehicle bean will be
        created first always as person bean has dependency on it.
    * */
    @Bean
    public Person person() {
        Person person = new Person();
        person.setName("Lucy");
        person.setVehicle(vehicle());
        return person;
    }


}
