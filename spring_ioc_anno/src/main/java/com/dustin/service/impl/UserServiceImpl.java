package com.dustin.service.impl;

import com.dustin.dao.UserDao;
import com.dustin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @Classname UserServiceImpl
 * @Descrption TODO
 * @Date 2021/7/20下午 10:55
 * @Created By Dustin_Peng
 */
/*<bean id="userService" class="com.dustin.service.impl.UserServiceImpl">
</bean>*/
@Service("userService")
@Scope("singleton")
public class UserServiceImpl implements UserService {

    //<property name="userDao" ref="userDao"/>
//    @Autowired  //按照数据类型从Spring容器中进行匹配
//    @Qualifier("userDao")   //按照id值从容器中进行匹配，但是此处@Qualifier要结合@Autowired一起使用
    @Resource(name = "userDao",type = UserDao.class)    //相当于上述的两个结合
    private UserDao userDao;

    @Value("${jdbc.driverClassName}")
    private String driver;
/*    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/

    @Override
    public void save() {
        System.out.println(driver);
        userDao.save();
    }

    @PostConstruct
    public void init(){
        System.out.println("service对象的初始化方法");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("service对象的销毁方法");
    }
}
