package com.MicroService1.calculatormicroservice.Calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CalculatorMicroserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CalculatorMicroserviceApplication.class, args);
    }
}
