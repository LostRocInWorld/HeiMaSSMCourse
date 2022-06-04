package com.dustin.web;

import com.dustin.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname UserServlet
 * @Descrption TODO
 * @Date 2021/7/21下午 09:26
 * @Created By Dustin_Peng
 */
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(req.getServletContext());

        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(req.getServletContext());
        UserService userService =  app.getBean("userService",UserService.class);
        userService.save();
    }
}
