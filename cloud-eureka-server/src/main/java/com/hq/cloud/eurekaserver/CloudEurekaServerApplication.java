package com.hq.cloud.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServerApplication.class, args);
    }
}
