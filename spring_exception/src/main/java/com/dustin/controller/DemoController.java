package com.dustin.controller;

import com.dustin.exception.MyException;
import com.dustin.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;

/**
 * @Classname DemoController
 * @Descrption TODO
 * @Date 2021/7/30上午 02:32
 * @Created By Dustin_Peng
 */
@Controller
public class DemoController {
    @Autowired
    private DemoService demoService;

    @RequestMapping("/show")
    public String show(@RequestParam(value = "name",required = false) String name) throws FileNotFoundException, MyException {
        System.out.println("show running... ...");
//        demoService.show1();
        demoService.show5();
        return "index";
    }
}
