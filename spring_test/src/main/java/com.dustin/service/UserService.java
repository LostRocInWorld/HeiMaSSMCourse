package com.dustin.service;

import com.dustin.domain.User;

import java.util.List;

/**
 * @Classname UserService
 * @Descrption TODO
 * @Date 2021/7/24下午 08:55
 * @Created By Dustin_Peng
 */
public interface UserService {
    List<User> list();

    void save(User user, Long[] roleIds);

    void del(Long userId);

    User login(String username, String password);
}
