package com.dustin.service.impl;

import com.dustin.dao.RoleDao;
import com.dustin.domain.Role;
import com.dustin.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname RoleServiceImpl
 * @Descrption TODO
 * @Date 2021/7/24上午 05:18
 * @Created By Dustin_Peng
 */
public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> list() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}
