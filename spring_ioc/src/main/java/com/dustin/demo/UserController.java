package com.dustin.demo;

import com.dustin.service.UserService;
import com.dustin.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @Classname UserController
 * @Descrption TODO
 * @Date 2021/7/20上午 02:17
 * @Created By Dustin_Peng
 */
public class UserController {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = (UserService) context.getBean("userService");

        userService.save();

//        UserService userService = new UserServiceImpl();
//        userService.save();
    }
}
