package com.dustin.test;

import com.dustin.domain.Order;
import com.dustin.domain.User;
import com.dustin.mapper.OrderMapper;
import com.dustin.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Classname MyBatisTest
 * @Descrption TODO
 * @Date 2021/8/8上午 01:28
 * @Created By Dustin_Peng
 */
public class MyBatisTest2 {
    private OrderMapper orderMapper;

    //為@Test注解抽取前面加載mybatis核心配置文件并獲取userMapper，在@Test方法之前執行
    @Before
    public void before() throws IOException {
        System.out.println("test start ,抽取前面重複的代碼  ......");
        InputStream stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);    //將事務設置為自動提交
        orderMapper = sqlSession.getMapper(OrderMapper.class);
    }

    //@Test方法完成后會執行的方法
    @After
    public void after(){
        System.out.println("test complete......");
    }

    @Test
    public void testFindAll(){
        List<Order> orders = orderMapper.findAll();
        System.out.println(orders);
    }
    @Test
    public void testFindByUid(){
        List<Order> orders = orderMapper.findOrderByUid(1);
        System.out.println(orders);
    }

}
