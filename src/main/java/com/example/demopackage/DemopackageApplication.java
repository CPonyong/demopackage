package com.example.demopackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.demopackage")
public class DemopackageApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemopackageApplication.class, args);
    }

}
