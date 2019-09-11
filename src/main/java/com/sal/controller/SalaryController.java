package com.sal.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sal.Util.ResultUtil;
import com.sal.pojo.Result;
import com.sal.pojo.Salary;
import com.sal.service.SalaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "SalaryController|工资相关操作接口")
@RequestMapping(value = "salarym/salary")
public class SalaryController {
    @Autowired
   private SalaryService salaryService;

    //显示所有员工工资信息
    @RequestMapping(value = "/salaryall/{start}",method = RequestMethod.GET)
    @ApiOperation(value="显示所有员工工资信息", notes="显示所有员工工资信息")
    public Result salaryAll(@PathVariable Integer start)throws Exception{
        PageHelper.startPage(start,5,"person_id asc");
        List<Salary> list=salaryService.selectSalaryAll();
        PageInfo<Salary> page = new PageInfo<>(list);
        return ResultUtil.success("成功",page);
    }

    //添加员工工资信息
    @RequestMapping(value = "/addsalary",method = RequestMethod.POST)
    @ApiOperation(value="添加员工工资信息", notes="添加员工工资信息")
    public Result addSalary(@RequestBody Salary salary)throws Exception{
        return  ResultUtil.success(salaryService.addSalary(salary),null);

    }

    //删除员工工资信息
    @RequestMapping(value = "/deletesalary/{id}",method = RequestMethod.GET)
    @ApiOperation(value="删除员工工资信息", notes="删除员工工资信息")
    public Result deleteSalary(@PathVariable Integer id)throws Exception{
        return  ResultUtil.success(salaryService.deleteSalary(id),null);
    }

    //更新员工工资信息
    @RequestMapping(value = "/updatesalary",method = RequestMethod.POST)
    @ApiOperation(value="更新员工工资信息", notes="更新员工工资信息")
    public Result updateSalary(@RequestBody Salary salary)throws Exception{
        return  ResultUtil.success(salaryService.updateSalary(salary),null);

    }

    //显示所有按部门计算平均工资
    @RequestMapping(value = "/avgdepartment/{year}",method = RequestMethod.GET)
    @ApiOperation(value="显示所有按部门计算平均工资", notes="显示所有按部门计算平均工资")
    public Result avgDepartment(@PathVariable String year)throws Exception{
        return  ResultUtil.success("成功",salaryService.avgDepartment(year));
    }

    //显示按人统计年平均工资
    @RequestMapping(value = "/avgperson/{year}",method = RequestMethod.GET)
    @ApiOperation(value="显示按人统计年平均工资", notes="显示按人统计年平均工资")
    public Result avgPerson(@PathVariable  String year)throws Exception{
        return  ResultUtil.success("成功",salaryService.avgPerson(year));
    }

    //统计年平均工资
    @RequestMapping(value = "/avgsalary/{year}",method = RequestMethod.GET)
    @ApiOperation(value="统计年平均工资", notes="统计年平均工资")
    public Result avgSalary(@PathVariable String year)throws Exception{
        return ResultUtil.success("成功",salaryService.avgSalary(year));
    }
}
