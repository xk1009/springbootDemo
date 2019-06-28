package com.xuke.springboottest.demospringboot.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * 添加一个servlet
 * 范式一 使用注解的方式 在main方法上添加包扫描servlet
 */
@WebServlet(urlPatterns = "/myServlet1")// servlet 的访问路径
public class MyServlet1 extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print(" myServlet 1 fangshi1");
        resp.getWriter().flush();
        resp.getWriter().close();
    }
}
