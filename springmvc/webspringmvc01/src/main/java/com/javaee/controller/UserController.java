package com.javaee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/gotoResult")
    public ModelAndView gotoResult(ModelAndView modelAndView) {
        // 封装数据，指定页面
        modelAndView.addObject("nowdate", new Date() + " USER");
        // 对应result.jsp
        modelAndView.setViewName("result");
        return modelAndView;
    }
}
