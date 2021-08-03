package com.mingdev.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {

    List<Department> queryDepartment();
    Department getDepartmentById(int id);

}
