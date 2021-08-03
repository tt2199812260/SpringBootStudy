package com.mingdev.controller;

import com.mingdev.mapper.UserMapper;
import com.mingdev.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> userList = userMapper.queryUserList();
        for(User user :userList){
            System.out.println(user);

        }
        return userList;
    }

    @GetMapping("/getid/{id}")
    public User queryUserById(@PathVariable("id") int id){
        User user = userMapper.queryUserById(id);
        System.out.println(user);
        return user;

    }


    @GetMapping("/addUser")
    public String addUser(){
        userMapper.addUser(new User(30,"ming","123456"));
        return "ok";
    }

    @GetMapping("/updateUser")
    public String updateUser(){
        userMapper.updateUser(new User(30,"mingdev","123456"));
        return "ok";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(){
        userMapper.deleteUser(30);
        return "ok";
    }


}
