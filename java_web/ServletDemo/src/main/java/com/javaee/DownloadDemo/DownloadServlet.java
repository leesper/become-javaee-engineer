package com.javaee.DownloadDemo;

import sun.misc.BASE64Encoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

@WebServlet(urlPatterns = "/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("fileName");
        String filePath = fileName;
        String agent = req.getHeader("User-Agent");
        if (agent.contains("MSIE")) {
            fileName = URLEncoder.encode(fileName, "utf-8");
            fileName = fileName.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            BASE64Encoder base64Encoder = new BASE64Encoder();
            fileName = "=?utf-8?B?"
                    + base64Encoder.encode(fileName.getBytes("utf-8"))
                    + "?=";
        } else {
            fileName = URLEncoder.encode(fileName, "utf-8");
        }
        resp.setHeader("Content-Disposition", "attachment;filename="+fileName);

        String absPath = req.getServletContext().getRealPath(filePath);
        FileInputStream fis = new FileInputStream(absPath);
        OutputStream out = resp.getOutputStream();
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1) {
            out.write(bytes, 0, len);
        }
        fis.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
