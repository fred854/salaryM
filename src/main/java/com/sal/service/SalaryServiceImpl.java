package com.sal.service;

import com.sal.dao.SalaryMapper;
import com.sal.exception.MyException;
import com.sal.pojo.DepartmentSalary;
import com.sal.pojo.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
   private SalaryMapper salaryMapper;

    @Override
    public List<Salary> selectSalaryAll() {
        List<Salary> list=salaryMapper.selectSalaryAll();
        return list;
    }

    @Override
    public String addSalary(Salary salary) {
        Integer id=salaryMapper.addSalary(salary);
        if(id==0||id==null){
            throw new MyException(500,"添加失败");

        }
        return "添加成功！";
    }

    @Override
    public String deleteSalary(Integer salaryId) {
        Integer id=salaryMapper.deleteSalary(salaryId);
        if(id==0||id==null){
            throw new MyException(500,"删除失败");

        }
        return "删除成功";
    }

    @Override
    public String updateSalary(Salary salary) {
        Integer id=salaryMapper.updateSalary(salary);
        if(id==0||id==null){
            throw new MyException(500,"更新失败");

        }
        return "更新成功";
    }

    @Override
    public List<DepartmentSalary> avgDepartment(String year) {
        List<DepartmentSalary> list=salaryMapper.avgDepartment(year);
        return list;
    }

    @Override
    public List<Salary> avgPerson(String year) {
        if (year==null){
            throw new MyException(500,"输入错误");
        }
        List<Salary> list=salaryMapper.avgPerson(year);
        return list;
    }

    @Override
    public Double avgSalary(String year) {
        if (year==null){
            throw new MyException(500,"输入错误");
        }
        Double avg=salaryMapper.avgSalary(year);
        return avg;
    }
}
