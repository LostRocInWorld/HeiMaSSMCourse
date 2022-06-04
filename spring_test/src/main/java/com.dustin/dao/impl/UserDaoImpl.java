package com.dustin.dao.impl;

import com.dustin.dao.UserDao;
import com.dustin.domain.Role;
import com.dustin.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @Classname UserDaoImpl
 * @Descrption TODO
 * @Date 2021/7/24下午 08:57
 * @Created By Dustin_Peng
 */
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from sys_user";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public Long saveUser(User user) {
        String sql = "insert into sys_user values(?,?,?,?,?)";
//        jdbcTemplate.update(sql,null,user.getUsername(),user.getEmail(),user.getPassword(),user.getPassword());
        //返回当前保存的user的ID，是数据库自动生成的
        //可以使用jdbcTemplate的API获得生成的id
        /* update(org.springframework.jdbc.core.PreparedStatementCreator psc,
                          org.springframework.jdbc.support.KeyHolder generatedKeyHolder)


        */
        //创建PreparedStatementCreator
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                //使用原始jdbc完成PreparedStatement的组建
                //PreparedStatement.RETURN_GENERATED_KEYS代表返回生成的主键
                PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1, null);
                preparedStatement.setString(2, user.getUsername());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setString(5, user.getPhoneNum());
                return preparedStatement;
            }
        };
        //创建KeyHolder
        KeyHolder keyHolder = new GeneratedKeyHolder();
        //执行update
        jdbcTemplate.update(creator, keyHolder);

        //获得生成的主键
        long userId = keyHolder.getKey().longValue();
        return userId;
    }

    @Override
    public void saveUserRoleRel(Long userId, Long[] roleIds) {
        String sql = "insert into sys_user_role values (?,?)";
        for (Long roleId : roleIds) {
            jdbcTemplate.update(sql, userId, roleId);
        }
    }

    @Override
    public void delUserRoleRel(Long userId) {
        String sql = "delete from sys_user_role where userId=?";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public void delUser(Long userId) {
        String sql = "delete from sys_user where id=?";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public User findByUsernameAndPwd(String username, String password) throws EmptyResultDataAccessException {
        String sql = "select * from sys_user where username=? and password=?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
        return user;
    }
}
