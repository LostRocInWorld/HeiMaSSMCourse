package com.dustin.proxy.jdk;

/**
 * @Classname Advice
 * @Descrption 通知，增强的功能
 * @Date 2021/7/31下午 10:10
 * @Created By Dustin_Peng
 */
public class Advice {
    public void before(){
        System.out.println("前置增强");
    }

    public void after(){
        System.out.println("后置增强");
    }
}
