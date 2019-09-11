package com.sal.controller;

import com.sal.Util.ResultUtil;
import com.sal.pojo.Position;
import com.sal.pojo.Result;
import com.sal.service.PositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "PositionController|职称相关操作接口")
@RequestMapping(value = "salarym/position")
public class PositionController {
    @Autowired
    PositionService positionService;

    //显示所有职称信息
    @RequestMapping(value = "/positionall",method = RequestMethod.GET)
    @ApiOperation(value="显示所有职称信息", notes="显示所有职称信息")
    public Result positionAll()throws Exception{
        return ResultUtil.success("成功",positionService.selectPositionAll());

    }

    //添加职称
    @RequestMapping(value = "/addposition",method = RequestMethod.POST)
    @ApiOperation(value="添加职称", notes="添加职称")
    public Result addPostion(@RequestBody Position position)throws Exception{
       return ResultUtil.success(positionService.addPosition(position),null) ;
    }

    //删除职称
    @RequestMapping(value = "/deleteposition/{id}",method = RequestMethod.GET)
    @ApiOperation(value="删除职称", notes="删除职称")
    public Result deletePosition(@PathVariable Integer id)throws Exception{
        return ResultUtil.success(positionService.deletePosition(id),null) ;
    }

    //修改职称
    @RequestMapping(value = "/updateposition",method = RequestMethod.POST)
    @ApiOperation(value="修改职称", notes="修改职称")
    public Result updatePsition(@RequestBody Position position)throws Exception{
        return ResultUtil.success(positionService.updatePosition(position),null) ;
    }
}
