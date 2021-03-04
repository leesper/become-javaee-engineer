package com.kkb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TagController {
    @GetMapping("tagList")
    public String tagList(Integer courseId) {
        return "pages/tagList";
    }
}
