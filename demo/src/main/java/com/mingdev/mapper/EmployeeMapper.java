package com.mingdev.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {
    List<Employee> queryEmployee();
    Employee queryEmployeeById(int id);
    int addEmployee(Employee emp);
    int updateEmployee(Employee emp);
    int deleteEmployee(int id);

}

