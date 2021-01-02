package com.javaee.RegisterLoginDemo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserService service = new UserService();
        User user = service.login(username, password);

        System.out.println(String.format("user %s password %s", username, password));

        if (user != null) {
            resp.sendRedirect(req.getContextPath());
        } else {
            req.setAttribute("msg", "用户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
