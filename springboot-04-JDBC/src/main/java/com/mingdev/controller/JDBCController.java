package com.mingdev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询数据库所有的信息
    //没有实体类。数据库中的东西可以通过Map获取
    @RequestMapping("/userList")
    public List<Map<String,Object>>userList(){
        String sql = "select * from user";
        List<Map<String,Object>> list_maps = jdbcTemplate.queryForList(sql);
        return list_maps;
    }

    //增加数据  自动提交事务
    @GetMapping("/addUser")
    public String addUser(){
        String sql = "insert into testDB.user(id,name,pwd) values(4,'小明','123456')";
        jdbcTemplate.update(sql);
        return "update ok";

    }

    //修改
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id")int id){

        String sql = "update testDB.user set name=?,pwd=? where id="+id;

        //封装
        Object[] objects = new Object[2];
        objects[0]="小明";
        objects[1]= "123445";
        jdbcTemplate.update(sql,id);
        return "update OK";

    }

    //增加数据  自动提交事务
    @GetMapping("/delUser/{id}")
    public String delUser(@PathVariable("id")int id){
        String sql = "delete from testDB.user where id =?";
        jdbcTemplate.update(sql,id);
        return "delete ok";

    }



}
