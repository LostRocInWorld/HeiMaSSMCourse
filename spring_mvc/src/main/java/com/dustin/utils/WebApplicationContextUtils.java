package com.dustin.utils;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

/**
 * @Classname WebApplicationContextUtils
 * @Descrption TODO
 * @Date 2021/7/21下午 10:04
 * @Created By Dustin_Peng
 */
public class WebApplicationContextUtils {
    public static ApplicationContext getWebApplicationContext(ServletContext servletContext){
        return (ApplicationContext) servletContext.getAttribute("app");
    }
}
