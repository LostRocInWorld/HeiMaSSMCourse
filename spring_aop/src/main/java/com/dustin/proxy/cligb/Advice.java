package com.dustin.proxy.cligb;

/**
 * @Classname Advice
 * @Descrption TODO
 * @Date 2021/7/31下午 10:10
 * @Created By Dustin_Peng
 */
//通知，增强的功能
public class Advice {
    /*
        * @Author Dustin_Peng
        * @Descrption //切面类的前置增强
        * @Date 13:19  2022/3/18
        * @param:
        * @return void
    **/
    public void before(){
        System.out.println("前置增强");
    }

    public void after(){
        System.out.println("后置增强");
    }
}
