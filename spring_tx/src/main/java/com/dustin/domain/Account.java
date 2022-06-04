package com.dustin.domain;

import java.security.Principal;

/**
 * @Classname Account
 * @Descrption TODO
 * @Date 2021/8/3上午 03:43
 * @Created By Dustin_Peng
 */
public class Account {
    private String name;
    private double money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
