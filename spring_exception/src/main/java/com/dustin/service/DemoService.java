package com.dustin.service;

import com.dustin.exception.MyException;

import java.io.FileNotFoundException;

/**
 * @Classname DemoService
 * @Descrption TODO
 * @Date 2021/7/30上午 02:35
 * @Created By Dustin_Peng
 */
public interface DemoService {
    void show1();
    void show2();
    void show3() throws FileNotFoundException;
    void show4();
    void show5() throws MyException;

}
