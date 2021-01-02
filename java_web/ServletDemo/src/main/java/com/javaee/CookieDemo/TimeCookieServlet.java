package com.javaee.CookieDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/last_time")
public class TimeCookieServlet extends HttpServlet {
    private static final String LASTTIME = "lastTime";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (LASTTIME.equals(cookie.getName())) {
                String value = cookie.getValue();
                resp.getWriter().println("您上次是在" + value + "的时候访问的");
                refreshCookie(req, resp);
                return;
            }
        }
        resp.getWriter().println("欢迎新用户光临本站");
        refreshCookie(req, resp);
    }

    private void refreshCookie(HttpServletRequest req, HttpServletResponse resp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String current = sdf.format(new Date());
        Cookie cookie = new Cookie(LASTTIME, current);
        cookie.setPath(req.getContextPath());
        cookie.setMaxAge(60* 10);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
