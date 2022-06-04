package com.dustin.dao.impl;

import com.dustin.dao.UserDao;
import com.dustin.main.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @Classname userDaoImpl
 * @Descrption TODO
 * @Date 2021/7/20上午 01:01
 * @Created By Dustin_Peng
 */
public class UserDaoImpl implements UserDao {
    private String username;
    private int age;

    private List<String> strList;
    private Map<String, User> userMap;
    private Properties properties;

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserDaoImpl() {
        System.out.println("UserDaoImpl對象創建");
    }

    public void init(){
        System.out.println("初始化方法");
    }

    public void destroy(){
        System.out.println("銷毀方法");
    }

    @Override
    public void save() {
        System.out.println("username="+username+",age="+age);
        System.out.println(strList);
        System.out.println(userMap);
        System.out.println(properties);
        System.out.println("save......");
    }
}
