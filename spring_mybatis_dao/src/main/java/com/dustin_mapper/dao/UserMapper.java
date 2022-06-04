package com.dustin_mapper.dao;

import com.dustin_mapper.domain.User;

import java.util.List;

/**
 * @Classname UserDao
 * @Descrption TODO
 * @Date 2021/8/5上午 04:28
 * @Created By Dustin_Peng
 */
public interface UserMapper {
    List<User> findByCondition(User user) ;
    List<User> findByIds(List<Integer> ids) ;

}
