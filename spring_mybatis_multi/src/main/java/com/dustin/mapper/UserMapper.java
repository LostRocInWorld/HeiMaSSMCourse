package com.dustin.mapper;

import com.dustin.domain.User;

import java.util.List;

/**
 * @Classname UserMapper
 * @Descrption TODO
 * @Date 2021/8/7上午 01:55
 * @Created By Dustin_Peng
 */
public interface UserMapper {
    List<User> findAll();
    List<User> findUserAndRole();
}
