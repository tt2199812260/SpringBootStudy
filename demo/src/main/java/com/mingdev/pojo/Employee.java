package com.mingdev.pojo;

import com.mingdev.mapper.DepartmentMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

//员工表
@Data
@NoArgsConstructor
public class Employee {

    private Integer id;
    private String lastName;
    private String email;
    private Integer gender; //0：女 ， 1：男
    private Integer departmentId;
    private Date birth;

    public Employee(Integer id, String lastName, String email, Integer gender, Integer departmentId) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.departmentId= departmentId;
        this.birth = new Date();
    }
}


