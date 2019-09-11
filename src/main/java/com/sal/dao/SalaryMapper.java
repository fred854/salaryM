package com.sal.dao;

import com.sal.pojo.DepartmentSalary;
import com.sal.pojo.Person;
import com.sal.pojo.Salary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SalaryMapper {
    //查询所有员工工资信息
    List<Salary> selectSalaryAll();

    //添加员工工资
    Integer addSalary(Salary salary);

    //删除员工工资
    Integer deleteSalary(Integer salaryId);

    //修改员工工资
    Integer updateSalary(Salary salary);

    //按部门计算平均工资
     List<DepartmentSalary> avgDepartment(String year);

     //按人统计年平均工资
    List<Salary> avgPerson(String year);

    //统计年平均工资
    Double avgSalary(String year);
}
