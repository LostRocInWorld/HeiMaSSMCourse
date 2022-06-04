package com.dustin.domain;

import java.util.Date;

/**
 * @Classname Order
 * @Descrption TODO
 * @Date 2021/8/7上午 01:56
 * @Created By Dustin_Peng
 */
public class Order {
    private int id;
    private Date ordertime;
    private double total;
    //当前订单属于哪一个用户
    private User user;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ordertime=" + ordertime +
                ", total=" + total +
                ", user=" + user +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
