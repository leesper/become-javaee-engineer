package com.javaee.controller;

import com.javaee.pojo.User;
import com.javaee.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Reference
    UserService userService;

    @RequestMapping("/find")
    public User find(Integer id) {
        return userService.find(id);
    }
}
