package com.dustin.service.impl;

import com.dustin.domain.Account;
import com.dustin.mapper.AccountMapper;
import com.dustin.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Classname AccountServiceImpl
 * @Descrption TODO
 * @Date 2021/8/13下午 09:49
 * @Created By Dustin_Peng
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    @Qualifier("accountMapper")
    private AccountMapper accountMapper;
    @Override
    public void save(Account account)  {
        accountMapper.save(account);
    }

    @Override
    public List<Account> findAll()  {
        return accountMapper.findAll();
    }
}
