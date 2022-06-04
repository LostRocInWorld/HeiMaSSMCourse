package com.dustin.test;

import com.dustin.quick.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * @Classname com.dustin.test.MybatisTest
 * @Descrption TODO
 * @Date 2021/8/4上午 02:31
 * @Created By Dustin_Peng
 */
public class MybatisTest {

    //查询操作
    @Test
    public void test1() throws IOException {
        //获得核心配置文件
        InputStream stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获得Session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        //获得sqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行查询操作  参数：namespace.id
        List<User> userList = sqlSession.selectList("userMapper.findAll");

        //打印数据
        System.out.println(userList);
        //释放资源
        sqlSession.close();
    }


//    插入操作
    @Test
    public void test2() throws IOException {
        //模拟web层传过来的User对象
        User user = new User();
        user.setUsername("ride");
        user.setPassword("11224455");

        //获得核心配置文件
        InputStream stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获得Session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        //获得sqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行插入操作  参数：namespace.id
        int insert = sqlSession.insert("userMapper.save",user);

        //mybatis事务默认不提交，执行更新操作，需要提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    //修改操作
    @Test
    public void test3() throws Exception {
        //模拟web层传过来的User对象
        User user = new User();
        user.setUsername("ride");
        user.setPassword("1234");

        //获得核心配置文件
        InputStream stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获得Session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        //获得sqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行插入操作  参数：namespace.id
        int insert = sqlSession.update("userMapper.update",user);

        //mybatis事务默认不提交，执行更新操作，需要提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    //删除操作
    @Test
    public void test4() throws Exception {
        //获得核心配置文件
        InputStream stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获得Session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        //获得sqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行插入操作  参数：namespace.id
        int insert = sqlSession.delete("userMapper.delete",5);
        //mybatis事务默认不提交，执行更新操作，需要提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    //byid查询操作
    @Test
    public void test5() throws IOException {
        //获得核心配置文件
        InputStream stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获得Session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        //获得sqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行查询操作  参数：namespace.id
        User user = sqlSession.selectOne("userMapper.findById",1);
        //打印数据
        System.out.println(user);
        //释放资源
        sqlSession.close();
    }
}
