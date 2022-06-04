package com.dustin.service.impl;

import com.dustin.dao.UserDao;
import com.dustin.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Classname UserServiceImpl
 * @Descrption TODO
 * @Date 2021/7/20上午 02:16
 * @Created By Dustin_Peng
 */
public class UserServiceImpl implements UserService {

    private  UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        userDao.save();
    }
}
