package com.dustin.proxy.jdk;

/**
 * @Classname Target
 * @Descrption 目标方法
 * @Date 2021/7/31下午 10:09
 * @Created By Dustin_Peng
 */
public class Target implements TargetInterface{
    @Override
    public void save() {
        System.out.println("save running... ...");
    }
}
