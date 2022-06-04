package com.dustin.dao;

import com.dustin.domain.Role;

import java.util.List;

/**
 * @Classname RoleDao
 * @Descrption TODO
 * @Date 2021/7/24上午 05:19
 * @Created By Dustin_Peng
 */
public interface RoleDao {
    List<Role> findAll();

    void save(Role role);

    List<Role> findRoleIdByUserId(Long id);
}
