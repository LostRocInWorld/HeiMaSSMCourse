package com.dustin.domain;

/**
 * @ Classname Account
 * @ Descrption 实体类Account
 * @ Date 2021/8/11上午 04:12
 * @ Created By Dustin_Peng
 */
public class Account {
    private Integer id;
    private String name;
    private double money;

    //getter&setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
