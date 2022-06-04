package com.dustin.test;

import com.dustin.config.SpringConfiguration;
import com.dustin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Classname SpringJunitTest
 * @Descrption TODO
 * @Date 2021/7/21上午 04:07
 * @Created By Dustin_Peng
 */

@RunWith(SpringJUnit4ClassRunner.class) //junit4
//@ContextConfiguration(value = "classpath:applicationContext.xml")   //加载配置文件
@ContextConfiguration(classes = {SpringConfiguration.class})    //加载配置类
//@ContextConfiguration()
public class SpringJunitTest {
    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;
    @Test
    public void test1(){
        userService.save();
    }

    @Test
    public void test2() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
}
