package com.dustin.controller;

import com.dustin.domain.Role;
import com.dustin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Classname RollController
 * @Descrption TODO
 * @Date 2021/7/24上午 05:13
 * @Created By Dustin_Peng
 */
@RequestMapping("/role")
@Controller
public class RoleController {
    @Autowired
    @Qualifier("roleService")
    private RoleService roleService ;

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping("/roleList")
    public ModelAndView roleList(){
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList=roleService.list();
        //设置模型
        modelAndView.addObject("roleList",roleList);
        //设置视图
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:/role/roleList";//不会被试图解析器解析，因为有redirect
    }
}
