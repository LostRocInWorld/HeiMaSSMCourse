package com.dustin.factory;

import com.dustin.dao.UserDao;
import com.dustin.dao.impl.UserDaoImpl;

/**
 * @Classname DynamicFactory
 * @Descrption TODO
 * @Date 2021/7/20上午 02:11
 * @Created By Dustin_Peng
 */
public class DynamicFactory {

    public  UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
