package com.energymeter.consumptionmanagerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumptionManagerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumptionManagerServiceApplication.class, args);
    }
}
