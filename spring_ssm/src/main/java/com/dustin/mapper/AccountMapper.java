package com.dustin.mapper;

import com.dustin.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Classname AccountMapper
 * @Descrption TODO
 * @Date 2021/8/11上午 04:13
 * @Created By Dustin_Peng
 */
public interface AccountMapper {
    @Insert("insert into account values (#{id},#{name},#{money})")
    void save(Account account);

    @Select("select * from account")
    List<Account> findAll();
}
