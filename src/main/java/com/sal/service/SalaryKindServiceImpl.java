package com.sal.service;

import com.sal.dao.SalaryKindMapper;
import com.sal.exception.MyException;
import com.sal.pojo.SalaryKind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SalaryKindServiceImpl implements SalaryKindService {
   @Autowired
   private SalaryKindMapper salaryKindMapper;
    @Override
    public List<SalaryKind> selectSalayKindAll() {
        List<SalaryKind> list=salaryKindMapper.selectSalayKindAll();
        return list;
    }

    @Override
    public String addSalayKind(SalaryKind salaryKind) {
        Integer id=salaryKindMapper.addSalayKind(salaryKind);
        if(id==0||id==null){
            throw new MyException(500,"添加失败！");
        }
        return "添加成功";
    }

    @Override
    public String deleteSalayKind(Integer salayKindId) {
        Integer id=salaryKindMapper.deleteSalayKind(salayKindId);
        if(id==0||id==null){
            throw new MyException(500,"删除失败！");
        }
        return "删除成功";
    }

    @Override
    public String updateSalayKind(SalaryKind salaryKind) {
        Integer id=salaryKindMapper.updateSalayKind(salaryKind);
        if(id==0||id==null){
            throw new MyException(500,"修改失败！");
        }
        return "修改成功";
    }
}
