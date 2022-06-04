package com.dustin.anno.target;

import org.springframework.stereotype.Component;

/**
 * @Classname Target
 * @Descrption TODO
 * @Date 2021/7/31下午 10:09
 * @Created By Dustin_Peng
 */
@Component("target")
public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("save running... ...");

        //模拟异常
//        int i  =1/0;
    }
}
