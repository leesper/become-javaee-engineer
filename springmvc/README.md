# SpringMVC框架

## 练习题

1. 解答题

（1）在早期 Java Web 的开发中出现的弊端

早期的Java Web开发是基于JSP的。JSP model1的第一代将所有的代码逻辑都耦合在了JSP里面；JSP model1的第二代引入了JavaBean，然后把业务逻辑交给它来处理，JSP负责控制和视图；JSP model2正式引入了三层架构：Model+View+Controller。

（2）SpringMVC的处理流程个人概述

五大核心组件：

* DispatcherServlet：前端控制器，负责分发请求，处理各种响应
* HandlerMapping：建立URL和处理器映射关系
* Controller：控制器
* ModelAndView：控制器处理的结果，逻辑视图
* ViewResolver：将逻辑视图转化为物理视图（JSP，FreeMaker等）

请求发送给DispatcherServlet，DispatcherServlet通过HandlerMapping找到对应的Handler，交给HandlerAdapter处理，HandlerAdapter调用Handler处理返回ModelAndView，DispatcherServlet将ModelAndView交给ViewResolver处理得到View，返回给客户端作为响应结果。

（3）SpringMVC注解有哪些，并描述其作用？

* @Controller：控制器注解，会扫描所有带@Controller注解的类，构建HandlerMapping
* @RequestMapping：控制器类中的处理方法
* @RequestParam：匹配参数名称
* @PostMapping：表示该方法处理POST请求
* @GetMapping：表示该方法处理GET请求

2. 解答题

（1）JSON定义 和JSON的结构

（2）请谈一下你对AJAX的认识，AJAX最大的特点是什么。

（3）什么是RESTful？