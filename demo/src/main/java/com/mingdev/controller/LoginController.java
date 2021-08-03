package com.mingdev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String pasword,
                        Model model, HttpSession session){

        //具体业务
        if(!StringUtils.isEmpty(username)&&"123456".equals(pasword)){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }
        else {
            model.addAttribute("msg","用户名或密码错误！");
            return "index";
        }

    }

    @RequestMapping("/user/logout")
    public String signOut(HttpSession session){
        session.invalidate();
        return  "redirect:/index.html";
    }
}
