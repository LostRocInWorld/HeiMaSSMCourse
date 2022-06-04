package com.dustin.mapper;

import com.dustin.domain.Order;
import com.dustin.domain.User;
import com.dustin.handler.DateLongHandler;
import com.dustin.handler.DateStringHandler;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Classname OrderMapper
 * @Descrption TODO
 * @Date 2021/8/7上午 02:05
 * @Created By Dustin_Peng
 */
public interface OrderMapper {
    //    @Select("select o.id oid,o.ordertime,o.total,o.uid,u.username,u.password,u.birthday from orders o,user u where o.uid=u.id")
//    @Results({
//            @Result(column = "oid",property = "id"),
//            @Result(column = "ordertime",property = "ordertime",typeHandler = DateStringHandler.class),
//            @Result(column = "total",property = "total"),
//            @Result(column = "uid",property = "user.id"),
//            @Result(column = "username",property = "user.username"),
//            @Result(column = "password",property = "user.password"),
//            @Result(column = "birthday",property = "user.birthday",typeHandler = DateLongHandler.class)
//    })
    @Select("select * from orders o")
    @Results({
            @Result(column = "oid", property = "id"),
            @Result(column = "ordertime", property = "ordertime", typeHandler = DateStringHandler.class),
            @Result(column = "total", property = "total"),
            @Result(
                    property = "user",  //要封装的实体属性名称
                    column = "uid", //根据外面的uid查询user表的数据
                    javaType = User.class,   //要封装的实体类型
                    one = @One(select = "com.dustin.mapper.UserMapper.findById")  //select属性代表查询哪个接口的方法获得数据
            )
    })
    List<Order> findAll();

    @Select("select * from orders where uid=#{uid}")
    List<Order> findOrderByUid(Integer uid);
}
