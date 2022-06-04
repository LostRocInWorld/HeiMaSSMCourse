package com.dustin.test;

import com.dustin.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Classname SpringTest
 * @Descrption TODO
 * @Date 2021/7/20上午 01:25
 * @Created By Dustin_Peng
 */
public class SpringTest {
    //測試scope屬性
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) context.getBean("userDao");

        System.out.println(userDao1);
        //手動關閉容器
//        ((ClassPathXmlApplicationContext)context).close();
    }
}
