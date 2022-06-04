package com.dustin.domain;

import java.util.List;

/**
 * @Classname VO
 * @Descrption TODO
 * @Date 2021/7/22下午 09:16
 * @Created By Dustin_Peng
 */
public class VO {
    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "VO{" +
                "userList=" + userList +
                '}';
    }
}
