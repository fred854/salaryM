package com.sal.dao;

import com.sal.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component(value ="departmentMapper")
public interface DepartmentMapper {
    //查询所有部门
    List<Department> selectDepartmentAll();

    //添加部门
    Integer addDepartment(Department department);

    //删除部门
    Integer deleteDepartment(Integer departmentId);

    //修改部门
    Integer updateDepartment(Department department);


}
