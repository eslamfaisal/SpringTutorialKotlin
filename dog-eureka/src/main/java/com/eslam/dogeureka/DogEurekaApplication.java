package com.eslam.dogeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DogEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DogEurekaApplication.class, args);
    }

}
