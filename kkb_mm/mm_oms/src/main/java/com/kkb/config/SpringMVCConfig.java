package com.kkb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMVCConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("pages/index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/userList").setViewName("pages/userList");
        registry.addViewController("/comList").setViewName("pages/comList");
        registry.addViewController("/industryList").setViewName("pages/industryList");
        registry.addViewController("/questionBasicList").setViewName("pages/questionBasicList");
        registry.addViewController("/questionClassicList").setViewName("pages/questionClassicList");
        registry.addViewController("/courseList").setViewName("pages/courseList");
    }
}
