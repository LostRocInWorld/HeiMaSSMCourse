package com.dustin.dao.impl;

import com.dustin.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Classname AccountDaoImpl
 * @Descrption TODO
 * @Date 2021/8/3上午 03:46
 * @Created By Dustin_Peng
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void out(String outMan, double money) {
        String sql="update account set money=money-? where name = ?" ;
        jdbcTemplate.update(sql,money,outMan);
    }

    @Override
    public void in(String inMan, double money) {
        String sql="update account set money=money+? where name = ?" ;
        jdbcTemplate.update(sql,money,inMan);
    }
}
