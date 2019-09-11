package com.sal.service;

import com.sal.pojo.SalaryKind;

import java.util.List;

public interface SalaryKindService {
    //查询所有工资类别
    List<SalaryKind> selectSalayKindAll();

    //添加工资类别
    String addSalayKind(SalaryKind salaryKind);

    //删除工资类别
    String deleteSalayKind(Integer salayKindId);

    //修改工资类别
    String updateSalayKind(SalaryKind salaryKind);
}
