package com.dustin.dao;

import org.springframework.stereotype.Repository;

/**
 * @Classname AccountDao
 * @Descrption TODO
 * @Date 2021/8/3上午 03:45
 * @Created By Dustin_Peng
 */
public interface AccountDao {
    void out(String outMan,double money);
    void in(String inMan,double money);
}
