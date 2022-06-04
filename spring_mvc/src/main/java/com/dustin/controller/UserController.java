package com.dustin.controller;

import com.dustin.domain.User;
import com.dustin.domain.VO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Classname UserController
 * @Descrption TODO
 * @Date 2021/7/22上午 01:56
 * @Created By Dustin_Peng
 */
@Controller
@RequestMapping("/user")
public class UserController {

    //请求地址  http://ip:port:/工程路径/user/quick
    @RequestMapping(value = "/quick",method = RequestMethod.GET,params = {"username","isn!=1990"})
    public String save(){
        System.out.println("Controller save running......");
        return "success";
    }


    @RequestMapping(value = "/quick2.do")
    public ModelAndView save2(){
        /*
        ModelAndView
        Model：模型，封装数据
        View：视图，展示数据
         */
        System.out.println("Controller save2 running......");
        ModelAndView modelAndView = new ModelAndView();
        //设置模型数据（放入了request域中）
        modelAndView.addObject("username","dustin02");
        //设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }


    @RequestMapping(value = "/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        //设置模型数据（放入了request域中）
        modelAndView.addObject("username","dustin03");
        //设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/quick4")
    public String save4(Model model){
        model.addAttribute("username","dustin04");
        return "success";
    }

    @RequestMapping(value = "/quick5")
    public String save5(HttpServletRequest request){
        request.setAttribute("username","dustin05");
        return "success";
    }

    @RequestMapping(value = "/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().println("helloworld");
    }

    @RequestMapping(value = "/quick7")
    @ResponseBody
    public String save7() throws IOException {
        return "hello world2";
    }

    //返回json字符串
    @RequestMapping(value = "/quick8")
    @ResponseBody
    public String save8() throws IOException {
        return "{\"username\":\"zhangsan\",\"age\":18}";
    }

    @RequestMapping(value = "/quick9")
    @ResponseBody
    public String save9() throws IOException {
        User user = new User();
        user.setUsername("lisi");
        user.setAge(40);
        //使用json的转换工具将对象转换成json字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String userJson = objectMapper.writeValueAsString(user);

        return userJson;
    }

    //期望SpringMVC框架将返回值转换成json字符串
    @RequestMapping(value = "/quick10")
    @ResponseBody
    public User save10() throws IOException {
        User user = new User();
        user.setUsername("wanger");
        user.setAge(50);
        return user;
    }


    @RequestMapping(value = "/quick11")
    @ResponseBody   //不跳转视图
    public void save11(String username,int age)  {    //void代表不回写数据
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping(value = "/quick12")
    @ResponseBody
    public void save12(User user)  {
        System.out.println(user.getAge());
        System.out.println(user.getUsername());
        System.out.println(user);
    }

    @RequestMapping(value = "/quick13")
    @ResponseBody
    public void save13(String[] strs)  {
        System.out.println(Arrays.asList(strs));
    }


    @RequestMapping(value = "/quick14",method = RequestMethod.POST)
    @ResponseBody
    public void save14(VO vo)  {
        System.out.println(vo);
    }

    @RequestMapping(value = "/quick15",method = RequestMethod.POST)
    @ResponseBody
    public void save15(@RequestBody List<User> userList)  {
        System.out.println(userList);
    }

    @RequestMapping(value = "/quick16",method = RequestMethod.GET)
    @ResponseBody
    public void save16(@RequestParam(value = "name",required = false,defaultValue = "李斯") String username)  throws  IOException{
        System.out.println(username);
    }

    //http://localhost:8080/spring_mvc/user/quick17/zhansan
    @RequestMapping(value = "/quick17/{name}")
    @ResponseBody
    public void save17(@PathVariable(value = "name",required = true) String username)  {
        System.out.println(username);
    }

    @RequestMapping(value = "/quick18")
    @ResponseBody
    public void save18(Date date)  {
        System.out.println(date);
    }

    @RequestMapping(value = "/quick19")
    @ResponseBody
    public void save19(HttpServletRequest request, HttpServletResponse response, HttpSession session)  {
        System.out.println("[request:"+request+"],[response:"+response+"],[session:"+session+"]");
    }

    @RequestMapping(value = "/quick20")
    @ResponseBody
    public void save20(@RequestHeader(value = "User-Agent",required = false) String useragent,@CookieValue(value = "JSESSIONID",required = false) String cookievalue)  {
        System.out.println("User-Agent:"+useragent);
        System.out.println("cookie:"+cookievalue);
    }

    @RequestMapping(value = "/quick21")
    @ResponseBody
    public void save21(String username, @RequestParam("upload") MultipartFile[] uploadFile) throws IOException {
        System.out.println("username："+username);
        System.out.println("uploadFile:  "+uploadFile);
        for (MultipartFile multipartFile : uploadFile) {
//            System.out.println(multipartFile.getName());//获取表单项的name属性名
            //获得上传文件的名称
            String originalFilename = multipartFile.getOriginalFilename();
            System.out.println("原始文件名:"+originalFilename);
            //保存到指定位置
            System.out.println("文件大小（字节）:"+multipartFile.getSize());
            if(""==originalFilename || null==originalFilename){
                System.out.println("没有文件名");
            }else
            {
                multipartFile.transferTo(new File("D:\\Users\\Dustin_Peng\\Desktop\\new_"+originalFilename));
            }
        }
    }


}