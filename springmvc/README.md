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

（1）JSON定义和JSON的结构

JSON是JavaScript Object Notation的意思，即JS对象表示。它使用花括号表示键值对，方括号表示数组，并 可以包含字符串、布尔值、null和数字等基本类型。

（2）请谈一下你对AJAX的认识，AJAX最大的特点是什么。

AJAX是异步JavaScript和XML的缩写。是一种对网页进行增量更新的技术，使用它可以不用刷新整个页面就能更新页面的某个子集。而且使用AJAX技术时前后端的数据交换是通过JSON进行的。

（3）什么是RESTful？

一种资源定位和操作的风格，POST表示插入，DELETE表示删除，GET表示查询，PUT表示修改，同一个资源描述符（URL）配上四种不同的方法，表示对资源的CRUD操作。

3. 解答题

（1）SpringMVC中如何解决请求中文乱码问题？

使用CharacterEncodingFilter过滤器，将其encoding属性配置成utf-8来解决。

（2）SpringMVC用什么对象从后台向前台传递数据的？

使用@ResponseBody，将数据转换成JSON格式向前台传递数据。

（3）拦截器的作用

HandlerMapping建立了URL和Handler之间的映射，DispatcherServlet在处理请求的时候会通过它找到对应的Handler，然后通过HandlerAdapter进行调用。拦截器的作用就是在Handler处理前，处理后，和绘制完视图时插入一些处理逻辑进行相应的处理。

4. 编程题：完成ssm框架整合（代码加截图）

参见代码ssmintegrate。