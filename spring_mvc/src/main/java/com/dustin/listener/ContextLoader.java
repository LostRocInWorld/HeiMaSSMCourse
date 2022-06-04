package com.dustin.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Classname ContextLoader
 * @Descrption servletContextListener加载配置文件创建ApplicationContext
 * @Date 2021/7/21下午 09:43
 * @Created By Dustin_Peng
 */
public class ContextLoader implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //读取web.xml的全局参数，提取配置文件位置
        ServletContext servletContext = servletContextEvent.getServletContext();
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        //加载Spring配置文件，创建Spring容器
        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocation);
        //将Spring的应用上下文对象ApplicationContext存储到ServletContext对象
        servletContext.setAttribute("app",app);
        System.out.println("Spring容器创建成功......");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
