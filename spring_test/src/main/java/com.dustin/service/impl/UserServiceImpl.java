package com.dustin.service.impl;

import com.dustin.dao.RoleDao;
import com.dustin.dao.UserDao;
import com.dustin.domain.Role;
import com.dustin.domain.User;
import com.dustin.service.UserService;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

/**
 * @Classname UserServiceImpl
 * @Descrption TODO
 * @Date 2021/7/24下午 08:56
 * @Created By Dustin_Peng
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> list() {
        List<User> userList = userDao.findAll();
        //封装userList中每个user的roles
        for (User user : userList) {
            //获得user的ID
            Long id = user.getId();
            //查询userId对应的role集合
            List<Role> roles = roleDao.findRoleIdByUserId(id);
            user.setRoles(roles);
        }
        return userList;
    }

    @Override
    public void save(User user, Long[] roleIds) {
        //向sys_user存储数据，并获取保存后数据库生成的id
        Long userId = userDao.saveUser(user);

        //向sys_user_role存储多条数据
        userDao.saveUserRoleRel(userId, roleIds);
    }

    @Override
    public void del(Long userId) {
        //1.刪除關係表sys_user_role
        userDao.delUserRoleRel(userId);
        //2.刪除sys_user
        userDao.delUser(userId);
    }

    @Override
    public User login(String username, String password) {
        User user = null;
        try {
            user = userDao.findByUsernameAndPwd(username, password);
            return user;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
