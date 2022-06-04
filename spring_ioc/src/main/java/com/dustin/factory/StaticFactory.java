package com.dustin.factory;

import com.dustin.dao.UserDao;
import com.dustin.dao.impl.UserDaoImpl;

/**
 * @Classname StaticFactory
 * @Descrption TODO
 * @Date 2021/7/20上午 02:06
 * @Created By Dustin_Peng
 */
public class StaticFactory {

    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }

}
