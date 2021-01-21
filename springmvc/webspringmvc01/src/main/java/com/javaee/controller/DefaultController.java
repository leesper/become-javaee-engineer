package com.javaee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/default")
public class DefaultController {
    @RequestMapping("/gotoResult")
    public ModelAndView gotoResult(ModelAndView modelAndView) {
        // 封装数据，指定页面
        modelAndView.addObject("nowdate", new Date() + " DEFAULT");
        // 对应result.jsp
        modelAndView.setViewName("result");
        return modelAndView;
    }

//    @RequestMapping(value = "/gotoResultMethod", method = RequestMethod.GET)
    @GetMapping("/gotoResultMethod")
    public ModelAndView gotoResultGet(ModelAndView modelAndView) {
        // 封装数据，指定页面
        modelAndView.addObject("nowdate", new Date() + " GET");
        // 对应result.jsp
        modelAndView.setViewName("result");
        return modelAndView;
    }

//    @RequestMapping(value = "/gotoResultMethod", method = RequestMethod.POST)
    @PostMapping("/gotoResultMethod")
    public ModelAndView gotoResultPost(ModelAndView modelAndView) {
        // 封装数据，指定页面
        modelAndView.addObject("nowdate", new Date() + " POST");
        // 对应result.jsp
        modelAndView.setViewName("result");
        return modelAndView;
    }
}
