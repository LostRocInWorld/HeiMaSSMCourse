package com.dustin.test;

import com.dustin.domain.User;
import com.dustin.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @Classname MyBatisTest
 * @Descrption TODO
 * @Date 2021/8/8上午 01:28
 * @Created By Dustin_Peng
 */
public class MyBatisTest {
    private UserMapper userMapper;

    //為@Test注解抽取前面加載mybatis核心配置文件并獲取userMapper，在@Test方法之前執行
    @Before
    public void before() throws IOException {
        System.out.println("test start ,抽取前面重複的代碼  ......");
        InputStream stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);    //將事務設置為自動提交
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    //@Test方法完成后會執行的方法
    @After
    public void after(){
        System.out.println("test complete......");
    }

    @Test
    public void testSave() {
        User user =new User();
        user.setUsername("wuli");
        user.setPassword("ab222c");
        user.setBirthday(new Date());
        userMapper.save(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setUsername("xisi");
        user.setPassword("1234");
        userMapper.update(user);
    }

    @Test
    public void testDelete(){
        userMapper.delete(10);
    }

    @Test
    public void testFindAll(){
        List<User> users = userMapper.findAll();
        System.out.println(users);
    }

    @Test
    public void testFindById(){
        User user = userMapper.findById(6);
        System.out.println(user);
    }

}
