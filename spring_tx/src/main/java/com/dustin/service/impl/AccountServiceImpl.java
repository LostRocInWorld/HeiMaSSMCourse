package com.dustin.service.impl;

import com.dustin.dao.AccountDao;
import com.dustin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Classname AccountServiceImpl
 * @Descrption TODO
 * @Date 2021/8/3上午 03:50
 * @Created By Dustin_Peng
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    @Qualifier("accountDao")
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,readOnly = false,timeout = -1)
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan,money);
        //模拟异常
        int i=1/0;
        accountDao.in(inMan,money);
    }
}
