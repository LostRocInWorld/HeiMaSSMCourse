package com.dustin.dao;

import com.dustin.domain.User;

import java.io.IOException;
import java.util.List;

/**
 * @Classname UserDao
 * @Descrption TODO
 * @Date 2021/8/5上午 04:28
 * @Created By Dustin_Peng
 */
public interface UserMapper {
    List<User> findAll() ;
    User findById(Integer id);
}
