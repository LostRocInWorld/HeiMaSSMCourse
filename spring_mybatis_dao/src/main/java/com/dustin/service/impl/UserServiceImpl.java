package com.dustin.service.impl;

import com.dustin.dao.UserMapper;
import com.dustin.domain.User;
import com.dustin.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @Classname UserServiceImpl
 * @Descrption TODO
 * @Date 2021/8/5上午 04:45
 * @Created By Dustin_Peng
 */
public class UserServiceImpl implements UserService {
    @Override
    public List<User> findAll() throws Exception {
        InputStream stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获得UserMapper接口的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findAll();
        return userList;
    }

    @Override
    public User findById(Integer id)  throws Exception{
        InputStream stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获得UserMapper接口的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findById(id);
        return user;
    }
}
