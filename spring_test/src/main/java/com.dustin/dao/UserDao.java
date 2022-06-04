package com.dustin.dao;

import com.dustin.domain.Role;
import com.dustin.domain.User;

import java.util.List;

/**
 * @Classname UserDao
 * @Descrption TODO
 * @Date 2021/7/24下午 08:57
 * @Created By Dustin_Peng
 */
public interface UserDao {
    List<User> findAll();

    Long saveUser(User user);

    void saveUserRoleRel(Long userId, Long[] roleIds);

    void delUserRoleRel(Long userId);

    void delUser(Long userId);

    User findByUsernameAndPwd(String username, String password);
}
