package com.sal.service;

import com.sal.dao.DepartmentMapper;
import com.sal.exception.MyException;
import com.sal.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
   private DepartmentMapper departmentMapper;

    @Override
    public List<Department> selectDepartmentAll() {
        List<Department> list= departmentMapper.selectDepartmentAll();
        return list;
    }

    @Override
    public String addDepartment(Department department) {
        Integer did=departmentMapper.addDepartment(department);
        if(did==0||did==null){
            throw new MyException(500,"添加失败！");
        }
        return "添加成功！";
    }

    @Override
    public String deleteDepartment(Integer departmentId) {
        Integer did=departmentMapper.deleteDepartment(departmentId);
        if(did==0||did==null){
            throw new MyException(500,"删除失败！");
        }
        return "删除成功！";
    }

    @Override
    public String updateDepartment(Department department) {
        Integer did=departmentMapper.updateDepartment(department);
        if(did==0||did==null){
            throw new MyException(500,"修改失败！");
        }
        return "修改成功！";
    }
}
