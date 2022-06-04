package com.dustin;

import com.dustin.domain.Order;
import com.dustin.domain.User;
import com.dustin.mapper.OrderMapper;
import com.dustin.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Classname MyBatisTest
 * @Descrption TODO
 * @Date 2021/8/7上午 02:29
 * @Created By Dustin_Peng
 */
public class MyBatisTest {

    //一对一查询
    @Test
    public void test() throws IOException {
        InputStream stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        List<Order> orderList = orderMapper.findAll();
        orderList.forEach(System.out::println);
    }

    @Test
    public void test2() throws ParseException {
        SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr= "2021-08-08 12:00:03";
        Date date = smp.parse(timeStr);
        System.out.println(date);
    }


    //一对多查询
    @Test
    public void test3() throws IOException {
        InputStream stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = userMapper.findAll();
        userList.forEach(System.out::println);
    }


    //多对多查询
    @Test
    public void test4() throws IOException {
        InputStream stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = userMapper.findUserAndRole();
        userList.forEach(System.out::println);
    }
}
