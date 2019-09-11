package com.sal.dao;


import com.sal.pojo.SalaryKind;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SalaryKindMapper {
    //查询所有工资类别
    List<SalaryKind> selectSalayKindAll();

    //添加工资类别
    Integer addSalayKind(SalaryKind salaryKind);

    //删除工资类别
    Integer deleteSalayKind(Integer salaryKindId);

    //修改工资类别
    Integer updateSalayKind(SalaryKind salaryKind);
}
