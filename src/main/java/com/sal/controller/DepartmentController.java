package com.sal.controller;

import com.sal.Util.ResultUtil;
import com.sal.pojo.Department;
import com.sal.pojo.Result;
import com.sal.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "DepartmentController|部门相关操作接口")
@RequestMapping("salarym/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    //显示所有部门信息
    @RequestMapping(value="/departmentall",method= RequestMethod.GET)
    @ApiOperation(value="显示所有部门信息", notes="显示所有部门信息")
    public Result departmentAll() throws Exception{
        return ResultUtil.success("成功",departmentService.selectDepartmentAll());
    }

    //添加部门
    @RequestMapping(value="/adddepartment",method= RequestMethod.POST)
    @ApiOperation(value="添加部门", notes="添加部门")
    public Result addDepartment(@RequestBody Department department) throws Exception{
        return ResultUtil.success(departmentService.addDepartment(department),null);
    }

    //删除部门
    @RequestMapping(value="/deletedepartment/{id}",method= RequestMethod.GET)
    @ApiOperation(value="删除部门", notes="删除部门")
    public  Result deleteDepartment(@PathVariable Integer id) throws Exception{
        return ResultUtil.success(departmentService.deleteDepartment(id),null);
    }

    //修改部门
    @RequestMapping(value="/updatedepartment",method= RequestMethod.POST)
    @ApiOperation(value="修改部门", notes="修改部门")
    public Result updateDeprtment(@RequestBody Department department) throws  Exception{
        return ResultUtil.success(departmentService.updateDepartment(department),null);
    }
}
