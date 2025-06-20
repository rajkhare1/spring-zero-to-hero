package com.example.config;

import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
* Spring @Configuration annotation is the part of the spring core framework.
* Spring Configuration annotation indicates that the class has @Bean definition
* methods. So Spring container can process the class and generate Spring Beans
* to be used in the application.
*
* To tell Spring it needs to search for classes annotated
* with stereotype annotations, we use the @ComponentScan annotation over the
* configuration class.
* */
@Configuration
@ComponentScan(basePackages = "com.example.beans")
public class ProjectConfig {

    @Bean
    public Vehicle vehicle1() {
        var veh = new Vehicle();
        veh.setName("Audi");
        return veh;
    }

    @Bean
    public Vehicle vehicle2() {
        var veh = new Vehicle();
        veh.setName("Honda");
        return veh;
    }

    @Bean
    public Vehicle vehicle3() {
        var veh = new Vehicle();
        veh.setName("Ferrari");
        return veh;
    }

}
