package com.mingdev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Array;
import java.util.Arrays;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("msg","<h1>Hello Mingdev!!<h1>");
        model.addAttribute("pets", Arrays.asList("dog","cat","bell"));
        return "index";
    }
}
