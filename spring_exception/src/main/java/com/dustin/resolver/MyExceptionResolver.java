package com.dustin.resolver;

import com.dustin.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Classname MyExceptionResolver
 * @Descrption TODO
 * @Date 2021/7/30上午 03:28
 * @Created By Dustin_Peng
 */
public class MyExceptionResolver implements HandlerExceptionResolver {

    /*
    参数e  异常对象
    返回值ModelAndView 跳转的错误视图信息
    * */

/*
    *@Author Dustin_Peng
    *@Descrption //TODO 
    *@Date 10:23  2022/3/18
    *@param: httpServletRequest
    *@param: httpServletResponse
    *@param: o
    *@param: e 异常对象
    * @return org.springframework.web.servlet.ModelAndView 跳转的错误视图信息
**/
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        if(e instanceof MyException){
            //如果抛出自定义异常MyException
            modelAndView.addObject("info","自定义异常");
        }else if(e instanceof ClassCastException){
            modelAndView.addObject("info","类型转换异常");
        }
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
