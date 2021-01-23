package com.javaee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("default")
public class DefaultController {
    @RequestMapping("gotoResultModel")
    public String gotoResultModel(Model model) {
        model.addAttribute("nowdate", new Date() + "===model");
        return "result";
    }

    @RequestMapping("gotoResultModelMap")
    public String gotoResultModelMap(ModelMap modelMap) {
        modelMap.addAttribute("nowdate", new Date() + "===modelMap");
        return "result";
    }

    @RequestMapping("gotoResultRedirect")
    public String gotoResultRedirect(ModelMap modelMap) {
        modelMap.addAttribute("nowdate", new Date() + "===modelMap");
        return "redirect:/default/gotoResultModelMap.do";
    }

    @RequestMapping("gotoResultForward")
    public String gotoResultForward(ModelMap modelMap) {
        modelMap.addAttribute("nowdate", new Date() + "===modelMap");
        return "forward:/default/gotoResultModelMap.do";
    }
}
