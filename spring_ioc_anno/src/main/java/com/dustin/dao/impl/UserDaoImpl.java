package com.dustin.dao.impl;

import com.dustin.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Classname UserDaoImpl
 * @Descrption TODO
 * @Date 2021/7/20下午 10:54
 * @Created By Dustin_Peng
 */
//<bean id="userDao" class="com.dustin.dao.impl.UserDaoImpl"/>
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("save running......");
    }
}
