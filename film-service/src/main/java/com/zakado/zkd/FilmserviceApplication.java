package com.zakado.zkd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FilmserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FilmserviceApplication.class, args);
    }
}