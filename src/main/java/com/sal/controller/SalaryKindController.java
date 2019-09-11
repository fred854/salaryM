package com.sal.controller;

import com.sal.Util.ResultUtil;
import com.sal.pojo.Result;
import com.sal.pojo.SalaryKind;
import com.sal.service.SalaryKindService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "SalaryKindController|工资类别相关操作接口")
@RequestMapping(value = "salarym/salaryKind")
public class SalaryKindController {
    @Autowired
   private SalaryKindService salaryKindService;

    //显示所有工资类别
    @RequestMapping(value = "/salarykindall",method = RequestMethod.GET)
    @ApiOperation(value="显示所有工资类别", notes="显示所有工资类别")
    public Result salaryKindAll()throws Exception{
        return ResultUtil.success("成功",salaryKindService.selectSalayKindAll());
    }

   //添加工资类别
   @RequestMapping(value = "/addsalarykind",method = RequestMethod.POST)
   @ApiOperation(value="添加工资类别", notes="添加工资类别")
    public  Result addSalaryKind(@RequestBody SalaryKind salaryKind)throws Exception{
        return ResultUtil.success(salaryKindService.addSalayKind(salaryKind),null);
    }

    //删除工资类别
    @RequestMapping(value = "/deletesalarykind/{id}",method = RequestMethod.GET)
    @ApiOperation(value="删除工资类别", notes="删除工资类别")
    public Result deleteSalaryKind(@PathVariable Integer id)throws Exception{
        return ResultUtil.success(salaryKindService.deleteSalayKind(id),null);
    }

    //修改工资类别
    @RequestMapping(value = "/updatesalarykind",method = RequestMethod.POST)
    @ApiOperation(value="修改工资类别", notes="修改工资类别")
    public Result updateSalaryKind(@RequestBody SalaryKind salaryKind)throws Exception{
        return ResultUtil.success(salaryKindService.updateSalayKind(salaryKind),null);
    }
}
