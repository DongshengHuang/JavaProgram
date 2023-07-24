package com.hds.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Boot302DemoApplication {

    public static void main(String[] args) {
        var ioc = SpringApplication.run(com.hds.boot302demo.Boot302DemoApplication.class, args);

        for (String name : ioc.getBeanDefinitionNames()) {
            // if(name == "user")
            if (name.equals("user")) {
                System.out.println(name);
            }
        }
    }

}
