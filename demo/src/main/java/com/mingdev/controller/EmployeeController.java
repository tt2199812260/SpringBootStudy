package com.mingdev.controller;


import com.mingdev.mapper.DepartmentMapper;
import com.mingdev.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private EmployeeMapper employeeMapper;


    @RequestMapping("/emps")
    public String list(Model model){
        List<Employee> employees = employeeMapper.queryEmployee();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    //跳转至添加界面，传入模板参数
    @GetMapping("/toAdd")
    public String toAdd(Model model){
        List<Department> departments = departmentMapper.queryDepartment();
        model.addAttribute("departments",departments);

        return "emp/add";
    }

    //接收数据，保存
    @GetMapping("/add")
    public String addEmp(Employee employee){
        employeeMapper.addEmployee(employee);
        System.out.println(employee);
        return "redirect:/emps";
    }

    //修改页面跳转
    @GetMapping("/updateEmp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id,Model model){
       Employee employee = employeeMapper.queryEmployeeById(id);
       model.addAttribute("emp",employee);
       Collection<Department> departments = departmentMapper.queryDepartment();
       model.addAttribute("departments",departments);
       return "emp/update";
    }

    //保存修改
    @PostMapping("/update")
    public String updateEmp(Employee employee){
        employeeMapper.updateEmployee(employee);
        System.out.println(employee);
        return "redirect:/emps";
    }

    //删除
    @GetMapping("/delEmp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeMapper.deleteEmployee(id);
        return "redirect:/emps";
    }

}
