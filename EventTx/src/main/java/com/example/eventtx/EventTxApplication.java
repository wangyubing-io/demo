package com.example.eventtx;

import com.example.eventtx.test.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan("com.example.eventtx.mapper")
@RequestMapping
@RestController
public class EventTxApplication {

    @Autowired
    private Test test;

    public static void main(String[] args) {
        SpringApplication.run(EventTxApplication.class, args);
    }

    @RequestMapping
    public String hello(){
        test.contextLoads();
        return "";
    }
}
