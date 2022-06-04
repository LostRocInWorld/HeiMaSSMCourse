package com.dustin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Classname TargetController
 * @Descrption TODO
 * @Date 2021/7/27上午 04:09
 * @Created By Dustin_Peng
 */
@Controller
public class TargetController {

    @RequestMapping("/target")
    public ModelAndView show(){
        System.out.println("目标资源执行中");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","Dustin_Peng");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
