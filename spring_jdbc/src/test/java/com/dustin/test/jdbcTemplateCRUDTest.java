package com.dustin.test;

import com.dustin.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Classname jdbcTemplateCRUDTest
 * @Descrption 使用spring集成的junit
 * @Date 2021/7/24上午 02:11
 * @Created By Dustin_Peng
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class jdbcTemplateCRUDTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    public void  testUpdate(){
        String sql="update account set money=? where name=?";
        jdbcTemplate.update(sql,10000,"tom");
    }

    @Test
    public void  testDelete(){
        String sql="delete from account  where name=?";
        jdbcTemplate.update(sql,"mary");
    }

    @Test
    public void  testQueryAll(){
        String sql="select name,money from account";
        List<Account> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(list);
    }

    @Test
    public void  testQueryOne(){
        String sql="select name,money from account where name= ?";
        Account tom = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class), "tom");
        System.out.println(tom);
    }

    @Test
    public void  testQueryCount(){
        String sql="select count(*) from account where name= ?";
        Long count = jdbcTemplate.queryForObject(sql, Long.class,"tom");
        System.out.println(count);
    }
}
