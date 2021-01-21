package com.javaee.controller;

import com.javaee.pojo.QueryVo;
import com.javaee.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/params")
public class ParamController {
    @RequestMapping("/gotoParams")
    public ModelAndView gotoParams(ModelAndView modelAndView,
                                   HttpServletRequest request,
                                   HttpServletResponse response,
                                   HttpSession session) {
        // 获取参数，封装数据，指定页面
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        System.out.println(id + name);

        // 对应result.jsp
        modelAndView.setViewName("result");

        return modelAndView;
    }

    @RequestMapping("/gotoParamsBase")
    public ModelAndView gotoParamsBase(ModelAndView modelAndView, Boolean isVIP) {
        // 获取参数，封装数据，指定页面
        modelAndView.addObject("nowdate", new Date() + "===" + isVIP);

        // 对应result.jsp
        modelAndView.setViewName("result");

        return modelAndView;
    }

    @RequestMapping("/gotoParamsRequestParam")
    public ModelAndView gotoParamsRequestParam(ModelAndView modelAndView, @RequestParam("id") Integer ids) {
        // 获取参数，封装数据，指定页面
        modelAndView.addObject("nowdate", new Date() + "===" + ids);

        // 对应result.jsp
        modelAndView.setViewName("result");

        return modelAndView;
    }

    @RequestMapping("/gotoParamsPojo")
    public ModelAndView gotoParamsPojo(ModelAndView modelAndView, User user) {
        // 获取参数，封装数据，指定页面
        modelAndView.addObject("nowdate", new Date() + "===" + user);

        // 对应result.jsp
        modelAndView.setViewName("result");

        return modelAndView;
    }

    @RequestMapping("/gotoParamsQueryVo")
    public ModelAndView gotoParamsQueryVo(ModelAndView modelAndView, QueryVo queryVo) {
        // 获取参数，封装数据，指定页面
        modelAndView.addObject("nowdate", new Date() + "===" + queryVo);

        // 对应result.jsp
        modelAndView.setViewName("result");

        return modelAndView;
    }
}
