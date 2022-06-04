package com.dustin.controller;

import com.dustin.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Classname AccountController
 * @Descrption TODO
 * @Date 2021/8/3上午 03:52
 * @Created By Dustin_Peng
 */
public class AccountController {
    //测试
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService= app.getBean(AccountService.class);
        accountService.transfer("tom","lucy",200);
        System.out.println("转账成功");
    }
}
