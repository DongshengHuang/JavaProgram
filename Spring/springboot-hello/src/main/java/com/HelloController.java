package com;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // @RequestMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    @RequestMapping("/annotation")
    public String say(){
        return "Hello Spring-Boot3 Annotation";
    }
}
