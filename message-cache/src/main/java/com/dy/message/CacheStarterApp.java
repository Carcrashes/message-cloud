package com.dy.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(value = {"com.dy.message","com.msb.framework"})
public class CacheStarterApp {
    public static void main(String[] args) {

        SpringApplication.run(CacheStarterApp.class,args);
    }
}