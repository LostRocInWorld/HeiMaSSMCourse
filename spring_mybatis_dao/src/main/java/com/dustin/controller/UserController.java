package com.dustin.controller;

import com.dustin.domain.User;
import com.dustin.service.UserService;
import com.dustin.service.impl.UserServiceImpl;

import java.util.List;

/**
 * @Classname UserController
 * @Descrption TODO
 * @Date 2021/8/5上午 04:48
 * @Created By Dustin_Peng
 */
public class UserController {
    public static void main(String[] args) throws Exception {
        UserService userService = new UserServiceImpl();
        List<User> user = userService.findAll();
        System.out.println(user);
        User user1 = userService.findById(1);
        System.out.println(user1);
    }
}
