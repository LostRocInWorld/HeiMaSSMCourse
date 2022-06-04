package com.dustin.controller;

import com.dustin.domain.Account;
import com.dustin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * @Classname AccountController
 * @Descrption TODO
 * @Date 2021/8/13下午 09:49
 * @Created By Dustin_Peng
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    //注入AccountService
    @Autowired
    @Qualifier("accountService")
    private AccountService accountService;
    //produces響應數據的數據類型
    @RequestMapping(value = "/save",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(Account account) throws IOException {
        accountService.save(account);
        return "恭喜保存成功";
    }

    //查詢
    @RequestMapping("/findAll")
    public ModelAndView findAll() throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        List<Account> accountList = accountService.findAll();
        modelAndView.addObject("accountList",accountList);
        modelAndView.setViewName("accountList");
        return modelAndView;
    }
}
