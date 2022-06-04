package com.dustin.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Classname JdbcTemplateTest
 * @Descrption 测试JdbcTemplate的开发步骤
 * @Date 2021/7/23上午 04:46
 * @Created By Dustin_Peng
 */
public class JdbcTemplateTest {

    //测试JdbcTemplate的开发步骤--原始操作
    @Test
    public void test1(){
        //创建数据源对象
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db_test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //设置数据源,知道数据库在哪
        jdbcTemplate.setDataSource(dataSource);
        //执行操作，insert
        String sql="insert into account values(?,?)";
        int row = jdbcTemplate.update(sql, "tom", 5000);
        System.out.println("成功塞入"+row+"行");
    }

    //测试Spring产生jdbcTemplate对象
    @Test
    public void test2(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);
        //执行操作
        String sql="insert into account values(?,?)";
        int row = jdbcTemplate.update(sql, "mary", 3000);
        System.out.println("成功塞入"+row+"行");
    }


}
