package com.dustin.web;

import com.dustin.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Classname UserController
 * @Descrption TODO
 * @Date 2021/7/20下午 11:00
 * @Created By Dustin_Peng
 */
public class UserController {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(com.dustin.config.SpringConfiguration.class);
        UserService userService = app.getBean( UserService.class);
        userService.save();
        //手动关闭容器用于测试销毁方法
        app.close();
    }
}
