package com.dustin.mapper;

import com.dustin.domain.User;

import java.util.List;

/**
 * @Classname UserMapper
 * @Descrption TODO
 * @Date 2021/8/6下午 09:52
 * @Created By Dustin_Peng
 */
public interface UserMapper {
    void save(User user);
    User findById(Integer id);
    List<User> findAll();
}
