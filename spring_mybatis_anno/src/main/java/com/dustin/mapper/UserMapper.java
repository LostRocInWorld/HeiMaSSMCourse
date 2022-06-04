package com.dustin.mapper;

import com.dustin.domain.User;
import com.dustin.handler.DateLongHandler;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.TypeHandler;

import java.util.List;

/**
 * @Classname UserMapper
 * @Descrption TODO
 * @Date 2021/8/8上午 01:27
 * @Created By Dustin_Peng
 */
public interface UserMapper {

    @Insert({"insert into user values (#{id},#{username},#{password},null)"})
    void save(User user);

    @Delete("delete from user where id=#{abcdidheiheihei}")
    void delete(Integer id);

    @Update("update user set password=#{password} where username=#{username} and password=#{password}")
    void update(User user);

    @Select("select * from user")
    List<User> findAll();

    @Select(value = "select * from user where id=#{id}")
    @Results({
            @Result(column = "birthday",typeHandler = DateLongHandler.class)
    })
    User findById(Integer id);

    @Select("select * from user")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(
                    property = "orderList",
                    column = "id",
                    javaType = List.class,
                    many=@Many(select ="com.dustin.mapper.OrderMapper.findOrderByUid")
            )}
    )
    List<User> findUserAndOrder();

    @Select("select * from user")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "username",property = "username",id = true),
            @Result(column = "password",property = "password",id = true),
            @Result(column = "birthday",property = "birthday",typeHandler = DateLongHandler.class),
            @Result(
                    property = "roleList",
                    column = "id",
                    javaType = List.class,  //查询的结果类型
                    many = @Many(select = "com.dustin.mapper.RoleMapper.findByUid")
            )
    })
    List<User> findUserAndRole();


}
