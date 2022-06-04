package com.dustin_mapper;

import com.dustin_mapper.dao.UserMapper;
import com.dustin_mapper.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname test
 * @Descrption TODO
 * @Date 2021/8/6上午 03:34
 * @Created By Dustin_Peng
 */
public class test {
    @Test
    public void test1() throws IOException {
        InputStream stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获得UserMapper接口的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //模拟条件
        User condition = new User();
//        condition.setId(1);
//        condition.setUsername("zhangsan");
//        condition.setPassword("1234");

        List<User> userList = mapper.findByCondition(condition);
        System.out.println(userList);
    }

    @Test
    public void test2() throws IOException {
        InputStream stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获得UserMapper接口的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //模拟条件
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(5);

        List<User> userList = mapper.findByIds(ids);
        System.out.println(userList);
    }
}
