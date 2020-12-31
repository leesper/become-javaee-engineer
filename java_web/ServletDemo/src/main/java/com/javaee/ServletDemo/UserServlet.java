package com.javaee.ServletDemo;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(String.format("user %s password %s", username, password));
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "SELECT * FROM user WHERE username=? AND password=?";
        Object[] params = {username, password};
        try {
            User user = qr.query(sql, new BeanHandler<User>(User.class), params);
            if (user != null) {
                resp.getWriter().println("Login Success");
            } else {
                resp.getWriter().println("Login Failed");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
