package com.hq.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class CloudOauth2ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudOauth2ServerApplication.class, args);
    }
}
