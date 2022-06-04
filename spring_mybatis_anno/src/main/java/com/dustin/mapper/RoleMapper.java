package com.dustin.mapper;

import com.dustin.domain.Role;
import com.dustin.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Classname RoleMapper
 * @Descrption TODO
 * @Date 2021/8/9下午 10:32
 * @Created By Dustin_Peng
 */
public interface RoleMapper {
    @Select("select * from user_role ur,role r where ur.roleId=r.id and ur.userId=#{uid}")
    List<Role> findByUid(Integer uid);
}
