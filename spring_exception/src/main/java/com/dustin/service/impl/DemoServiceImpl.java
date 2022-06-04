package com.dustin.service.impl;

import com.dustin.exception.MyException;
import com.dustin.service.DemoService;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @Classname DemoServiceImpl
 * @Descrption TODO
 * @Date 2021/7/30上午 02:36
 * @Created By Dustin_Peng
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public void show1() {
        System.out.println("抛出類型轉換異常...");
        Object str = "zhangsan";
        Integer num = (Integer) str;
    }

    @Override
    public void show2() {
        System.out.println("抛出除零異常...");
        int i = 12/0;
    }

    @Override
    public void show3() throws FileNotFoundException {
        System.out.println("抛出文件找不到異常");
        InputStream in = new FileInputStream("C:/XXX/XXX/SS.txt");
    }

    @Override
    public void show4() {
        System.out.println("空指針異常...");
        String str=null;
        str.length();
    }

    @Override
    public void show5() throws MyException {
        System.out.println("自定義異常...");
        throw new MyException();    //手動抛出一個Exception
    }
}
