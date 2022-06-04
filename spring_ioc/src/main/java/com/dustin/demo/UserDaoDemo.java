package com.dustin.demo;

import com.dustin.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Classname UserDaoDemo
 * @Descrption TODO
 * @Date 2021/7/20上午 01:04
 * @Created By Dustin_Peng
 */
public class UserDaoDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.save();
    }
}
