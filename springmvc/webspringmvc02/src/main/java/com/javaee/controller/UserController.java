package com.javaee.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    @PostMapping("user/{id}")
    public String save(@PathVariable("id") Integer id) {
        System.out.println(id);
        return "post...ok";
    }

//    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("user/{id}")
    public String delete(@PathVariable("id") Integer id) {
        System.out.println(id);
        return "delete...ok";
    }

//    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    @PutMapping("user/{id}")
    public String update(@PathVariable("id") Integer id) {
        System.out.println(id);
        return "put...ok";
    }

//    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @GetMapping("user/{id}")
    public String find(@PathVariable("id") Integer id) {
        System.out.println(id);
        return "get...ok";
    }
}
