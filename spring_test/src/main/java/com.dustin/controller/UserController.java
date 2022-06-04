package com.dustin.controller;

import com.dustin.dao.RoleDao;
import com.dustin.domain.Role;
import com.dustin.domain.User;
import com.dustin.service.RoleService;
import com.dustin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Classname UserController
 * @Descrption TODO
 * @Date 2021/7/24下午 08:53
 * @Created By Dustin_Peng
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @RequestMapping("/userList")
    public ModelAndView userList(){
        List<User> userList=userService.list();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/saveUI")
    public ModelAndView saveUI(){
        ModelAndView modelAndView = new ModelAndView();

        List<Role> roleList = roleService.list();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-add");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(User user,Long[] roleIds){   //Spring自动进行封装
        ModelAndView modelAndView = new ModelAndView();
        userService.save(user,roleIds);

        return "redirect:/user/userList";
    }

    @RequestMapping("/del/{userId}")
    public String del(@PathVariable Long userId){
        userService.del(userId);
        return "redirect:/user/userList";
    }


    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){   //Spring自动进行封装
        User user = userService.login(username,password);
        if(user!=null){
            //登录成功
            session.setAttribute("user",user);
            return "redirect:/index.jsp";
        }
        //登录失败跳转登录页面
        return "redirect:/login.jsp";
    }
}
