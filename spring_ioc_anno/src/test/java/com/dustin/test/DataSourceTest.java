package com.dustin.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.util.ResourceBundle;

/**
 * @Classname DataSourceTest
 * @Descrption TODO
 * @Date 2021/7/20上午 04:23
 * @Created By Dustin_Peng
 */
public class DataSourceTest {

    //测试手动创建c3p0数据源
    @Test
    public void test1() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        // 设置数据源的基本连接数据
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/db_test");
        dataSource.setUser("root");
        dataSource.setPassword("root");

        //获取资源
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        //关闭连接，归还
        connection.close();
    }

    //测试手动创建Druid数据源
    @Test
    public void test2() throws Exception {
        DruidDataSource dataSource = new DruidDataSource();
        // 设置数据源的基本连接数据
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db_test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        //获取资源
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        //关闭连接，归还
        connection.close();
    }


    //测试手动创建c3p0数据源--加载配置文件jdbc.properties
    @Test
    public void test3() throws Exception {
        //读取配置文件
        /*public static final ResourceBundle getBundle(String baseName)
             baseName相对于类加载路径，即resources下
             */
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        String driverClassName = rb.getString("jdbc.driverClassName");
        String url = rb.getString("jdbc.url");
        String username = rb.getString("jdbc.name");
        String password = rb.getString("jdbc.password");

        //创建数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        // 设置数据源的基本连接数据
        dataSource.setDriverClass(driverClassName);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);

        //获取资源
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        //关闭连接，归还
        connection.close();
    }

    //测试Spring容器产生数据源对象
    @Test
    public void test4() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-test.xml");
        DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    }
