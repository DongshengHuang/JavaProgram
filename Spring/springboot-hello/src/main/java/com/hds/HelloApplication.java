package com.hds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// @SpringBootApplication(scanBasePackages = "com")
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com")
public class HelloApplication {
    public static void main(String[] args) {
        var ioc = SpringApplication.run(HelloApplication.class, args);
        String[] names = ioc.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

    }
}
