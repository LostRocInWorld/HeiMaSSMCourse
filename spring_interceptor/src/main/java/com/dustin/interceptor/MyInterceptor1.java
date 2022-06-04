package com.dustin.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Classname MyInterceptor
 * @Descrption TODO
 * @Date 2021/7/28上午 01:29
 * @Created By Dustin_Peng
 */
public class MyInterceptor1 implements HandlerInterceptor {

    //在目標方法執行之前執行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        String param = request.getParameter("param");
        if("yes".equals(param)){
            return true;
        } else {
            request.getRequestDispatcher("/error.jsp").forward(request,response);
            return false;    //返回true代表放行，返回false代表不放行
        }
    }

    //在目標方法執行之後 視圖返回之前執行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("name","靓仔");
        System.out.println("postHandle1");
    }
    //在整个流程都执行完毕后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion1");
    }
}
