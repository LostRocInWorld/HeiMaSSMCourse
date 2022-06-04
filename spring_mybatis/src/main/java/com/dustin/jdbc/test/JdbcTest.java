package com.dustin.jdbc.test;

import com.dustin.jdbc.domain.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Classname JdbcTest
 * @Descrption TODO
 * @Date 2021/8/4上午 01:24
 * @Created By Dustin_Peng
 */
public class JdbcTest {
    public static void query() throws Exception {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获得连接
        Connection connection= DriverManager.getConnection("jdbc:mysql:///test","root","root");
//        获得statement
        PreparedStatement preparedStatement = connection.prepareStatement("select name,money from account");
        //执行查询
        ResultSet resultSet = preparedStatement.executeQuery();
        //遍历结果集
        while(resultSet.next()){
            //封装实体
            Account account = new Account();
            account.setName(resultSet.getString(1));
            account.setMoney(resultSet.getDouble("money"));
            //输出
            System.out.println(account);
        }
        //释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    public static void update() throws Exception {
        Account account = new Account();
        account.setName("liangzai");
        account.setMoney(70000D);

        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获得连接
        Connection connection= DriverManager.getConnection("jdbc:mysql:///test","root","root");
//        获得statement
        PreparedStatement preparedStatement = connection.prepareStatement("insert into account values(?,?)");

        //填充占位符
        preparedStatement.setString(1,account.getName());
        preparedStatement.setDouble(2,account.getMoney());

        //执行更新操作
        preparedStatement.executeUpdate();

        //释放资源
        preparedStatement.close();
        connection.close();

    }

    public static void main(String[] args) throws Exception {
        update();
    }
}
