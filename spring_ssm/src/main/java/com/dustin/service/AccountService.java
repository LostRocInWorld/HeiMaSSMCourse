package com.dustin.service;

import com.dustin.domain.Account;

import java.io.IOException;
import java.util.List;

/**
 * @Classname AccountService
 * @Descrption AccountService业务层
 * @Date 2021/8/13下午 09:48
 * @Created By Dustin_Peng
 */
public interface AccountService {
    void save(Account account) throws IOException;
    List<Account> findAll() throws IOException;
}
