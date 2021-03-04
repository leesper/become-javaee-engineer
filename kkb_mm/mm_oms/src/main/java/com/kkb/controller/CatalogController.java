package com.kkb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatalogController {
    @GetMapping("catalogList")
    public String catalogList(Integer courseId) {
        return "pages/catalogList";
    }
}
