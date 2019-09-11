package com.sal.service;

import com.sal.pojo.DepartmentSalary;
import com.sal.pojo.Salary;

import java.util.List;

public interface SalaryService {
   //查询所有员工工资信息
    List<Salary> selectSalaryAll();

    //添加员工工资
    String addSalary(Salary salary);

    //删除员工工资
    String deleteSalary(Integer salaryId);

    //修改员工工资
    String updateSalary(Salary salary);

    //按部门计算平均工资
    List<DepartmentSalary> avgDepartment(String year);

    //按人统计年平均工资
    List<Salary> avgPerson(String year);

    //统计年平均工资
    Double avgSalary(String year);
}
