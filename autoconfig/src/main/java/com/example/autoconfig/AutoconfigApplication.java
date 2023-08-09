package com.example.autoconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AutoconfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoconfigApplication.class, args);
    }

}
