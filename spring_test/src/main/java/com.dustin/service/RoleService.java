package com.dustin.service;

import com.dustin.domain.Role;

import java.util.List;

/**
 * @Classname RoleService
 * @Descrption TODO
 * @Date 2021/7/24上午 05:18
 * @Created By Dustin_Peng
 */
public interface RoleService {
    List<Role> list();
    void save(Role role);
}
