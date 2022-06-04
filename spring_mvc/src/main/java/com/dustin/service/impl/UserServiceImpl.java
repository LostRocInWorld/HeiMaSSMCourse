package com.dustin.service.impl;

import com.dustin.dao.UserDao;
import com.dustin.service.UserService;

/**
 * @Classname UserServiceImpl
 * @Descrption TODO
 * @Date 2021/7/21下午 09:14
 * @Created By Dustin_Peng
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        userDao.save();
    }
}
