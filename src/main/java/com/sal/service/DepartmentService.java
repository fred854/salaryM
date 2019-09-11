package com.sal.service;

import com.sal.pojo.Department;

import java.util.List;

public interface DepartmentService {
    //显示全部部门信息
    List<Department> selectDepartmentAll();

    //添加部门
    String addDepartment(Department department);

    //删除部门
    String deleteDepartment(Integer departmentId);

    //修改部门
    String updateDepartment(Department department);
}
