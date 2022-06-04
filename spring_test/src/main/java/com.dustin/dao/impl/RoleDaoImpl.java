package com.dustin.dao.impl;

import com.dustin.dao.RoleDao;
import com.dustin.domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Classname RoleDaoImpl
 * @Descrption TODO
 * @Date 2021/7/24上午 05:20
 * @Created By Dustin_Peng
 */
public class RoleDaoImpl implements RoleDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Role> findAll() {
        String sql="select * from sys_role";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Role>(Role.class));
    }

    @Override
    public void save(Role role) {
        String sql="insert into sys_role values(?,?,?)";
        jdbcTemplate.update(sql,null,role.getRoleName(),role.getRoleDesc());
    }

    @Override
    public List<Role> findRoleIdByUserId(Long id) {
        String sql="select r.* from sys_user_role ur,sys_role r  where ur.roleId=r.id and ur.userId=?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Role>(Role.class),id);
    }
}
