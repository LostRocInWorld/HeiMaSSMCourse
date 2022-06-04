package com.dustin.interceptor;

import com.dustin.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Classname PrivilegeInterceptor
 * @Descrption TODO
 * @Date 2021/7/28上午 03:19
 * @Created By Dustin_Peng
 */
public class PrivilegeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断用户是否登录--Session是否有user
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user==null){
            //没有登录，返回登录页面，不放行
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return false;
        }
        //放行，访问目标资源
        return true;
    }
}
