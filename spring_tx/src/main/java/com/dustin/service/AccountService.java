package com.dustin.service;

import org.springframework.stereotype.Service;

/**
 * @Classname AccountDao
 * @Descrption TODO
 * @Date 2021/8/3上午 03:49
 * @Created By Dustin_Peng
 */
public interface AccountService {
    void transfer(String outMan,String inMan,double money);
}
