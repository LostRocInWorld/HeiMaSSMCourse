package com.dustin.domain;

/**
 * @Classname User
 * @Descrption TODO
 * @Date 2021/7/22上午 06:47
 * @Created By Dustin_Peng
 */
public class User {
    private String username;
    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
