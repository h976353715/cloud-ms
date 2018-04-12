package com.hq.cloud.oauth2server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableFeignClients
@EnableResourceServer
@EnableDiscoveryClient
@SpringBootApplication
public class CloudOauth2ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudOauth2ServerApplication.class, args);
    }
}
