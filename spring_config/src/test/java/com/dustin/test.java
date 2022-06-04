package com.dustin;

import com.dustin.domain.User;
import com.dustin.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @ Classname test
 * @ Descrption TODO
 * @ Date 2021/8/6下午 09:57
 * @ Created By Dustin_Peng
 */
public class test {
    @Test
    public void test1() throws Exception {
        InputStream stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("test");
        user.setPassword("1234");
        user.setBirthday(new Date());
        //执行保存操作
        userMapper.save(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test2() throws Exception {
        InputStream stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //执行查询操作
        User user = userMapper.findById(6);
        System.out.println("user中的birthday:"+user.getBirthday());
        sqlSession.close();
    }

    @Test
    public void test3() throws Exception {
        InputStream stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //设置分页相关参数  当前页+每页显示的条数
        PageHelper.startPage(2,3);  //第一页，每页显示3条

        List<User> userList = userMapper.findAll();
        userList.forEach(System.out::println);

        //获得与分页相关的参数，当前页，上一页，下一页等等... ...
        PageInfo<User> pageInfo = new PageInfo<>(userList); //根据当前查询的分页数据获取
        //当前页
        System.out.println("当前页"+pageInfo.getPageNum());
        //每页显示条数
        System.out.println("每页显示条数"+pageInfo.getPageSize());
        //总条数
        System.out.println("总条数"+pageInfo.getTotal());
        //总页数
        System.out.println("总页数"+pageInfo.getPages());
        //上一页
        System.out.println("上一页"+pageInfo.getPrePage());
        //下一页
        System.out.println("下一页"+pageInfo.getNextPage());
        //是否是首页
        System.out.println("是否是首页:"+pageInfo.isIsFirstPage());
        //是否是最后一页
        System.out.println("是否是最后一页:"+pageInfo.isIsLastPage());
    }
}
