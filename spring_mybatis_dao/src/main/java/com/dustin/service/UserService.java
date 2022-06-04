package com.dustin.service;

import com.dustin.domain.User;

import java.util.List;

/**
 * @Classname UserService
 * @Descrption TODO
 * @Date 2021/8/5上午 04:44
 * @Created By Dustin_Peng
 */
public interface UserService {
    List<User> findAll() throws Exception;

    User findById(Integer id)  throws Exception;
}
