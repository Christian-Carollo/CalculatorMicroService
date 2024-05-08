package com.MicroService1.calculatormicroservice.RandomOperatorGenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RandomOperatorGeneratorMicroserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RandomOperatorGeneratorMicroserviceApplication.class, args);
    }
}
