package com.javaee.FilterDemo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@WebFilter("/safe")
public class SafeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        String[] products = servletRequest.getParameterValues("product");
        System.out.println(Arrays.toString(products));
        List<String> list = Stream.of(products)
                .filter(item -> !item.equals("冲锋枪"))
                .filter(item -> !item.equals("⼿榴弹"))
                .collect(Collectors.toList());
        System.out.println(list);
        servletRequest.setAttribute("list", list);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
