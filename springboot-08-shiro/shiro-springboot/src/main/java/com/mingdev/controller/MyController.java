package com.mingdev.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping({"/","/index"})
    public String index(Model model){
        model.addAttribute("msg","hello world");
        return "index";
    }

    @RequestMapping("user/add")
    public String add(){
        return "user/add";
    }

    @RequestMapping("user/update")
    public String update(){
        return "user/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping ("/login")
    public String login(String username,String password,Model model){

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try{
            subject.login(token);  //执行登录

            return "index";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "login";
        }

    }

    @RequestMapping("/noauth")
    @ResponseBody
    public String unatthorized(){
        return "未经授权，不能访问此页面";
    }

    @RequestMapping ("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }


}
