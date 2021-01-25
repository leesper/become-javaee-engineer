package com.javaee.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${person.name}")
    private String personName;

    @RequestMapping("/hello")
    public String hello (String name) {
        System.out.println("hello, " + personName);
        return "hello, " + name;
    }
}
