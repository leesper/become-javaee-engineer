package com.javaee.controller;

import com.javaee.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Controller
@RestController
@RequestMapping("ajax")
public class AjaxController {
//    @ResponseBody
    @RequestMapping("testAjax")
    public List<User> testAjax(@RequestBody User user) {
        System.out.println(user);
        User u1 = new User();
        u1.setId(3);
        u1.setUsername("Leesper");
        u1.setSex("男");

        User u2 = new User();
        u2.setId(5);
        u2.setUsername("Lucy");
        u2.setSex("女");

        return Arrays.asList(u1, u2);
    }
}
