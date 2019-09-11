package com.sal.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sal.Util.ConstantUtils;
import com.sal.Util.RedisToken;
import com.sal.Util.ResultUtil;
import com.sal.exception.MyException;
import com.sal.ext.ExtApiIdempotent;
import com.sal.pojo.Person;
import com.sal.pojo.Result;
import com.sal.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Api(value = "PersonController|人员相关操作接口")
@RequestMapping("salarym/personn")
public class PersonController {
   @Autowired
   private PersonService personService;

   @Autowired
   private RedisToken redisToken;

   //获取token并存放在redis中
    @RequestMapping(value="/redisToken",method= RequestMethod.GET)
    @ApiOperation(value="获取token并存放在redis中", notes="获取token并存放在redis中")
    public Result RedisToken(){
        String token=redisToken.getToken();
        return ResultUtil.success("成功",token);
    }

    //显示所有员工基础信息
    @RequestMapping(value="/personall/{start}",method= RequestMethod.GET)
    @ApiOperation(value="显示所有员工基础信息", notes="显示所有员工基础信息")
    public Result personAll(@PathVariable Integer start) throws Exception{
        PageHelper.startPage(start,5,"person_id asc");
        List<Person> list=personService.selectPersonAll();
        PageInfo<Person> page = new PageInfo<>(list);
        return ResultUtil.success("成功",page);
    }

    //添加人员
//    @RequestMapping(value="/addperson",method= RequestMethod.POST)
//    @ApiOperation(value="添加人员", notes="添加人员")
//    @ExtApiIdempotent(type = ConstantUtils.EXTAPIHEAD)
//    public Result addPerson(@RequestBody Person person, HttpServletRequest request)throws Exception{
//       //调用接口时，获取请求头的令牌
//        String token=request.getHeader("token");
//        if(StringUtils.isEmpty(token)){
//            throw new MyException(500,"添加失败！");
//        }
//       //如果能够从redis获取到这个令牌，就删掉这个令牌
//        boolean isToken=redisToken.findToken(token);
//        if(!isToken){
//            throw new MyException(500,"请勿重复提交！");
//        }
//        return ResultUtil.success(personService.addPerson(person),null);
//    }

    //添加人员
    @RequestMapping(value="/addperson",method= RequestMethod.POST)
    @ApiOperation(value="添加人员", notes="添加人员")
    @ExtApiIdempotent(type = ConstantUtils.EXTAPIHEAD)
    public Result addPerson(@RequestBody Person person, HttpServletRequest request)throws Exception{
        return ResultUtil.success(personService.addPerson(person),null);
    }

    //删除人员
    @RequestMapping(value="/deleteperson/{id}",method= RequestMethod.GET)
    @ApiOperation(value="删除人员", notes="删除人员")
    public Result deletePerson(@PathVariable Integer id)throws Exception{
        return ResultUtil.success(personService.deletePerson(id),null);
    }

    //修改人员信息
    @RequestMapping(value="/udateperson",method= RequestMethod.POST)
    @ApiOperation(value="修改人员信息", notes="修改人员信息")
    public Result updatePerson(@RequestBody Person person)throws Exception{
        return ResultUtil.success(personService.updatePerson(person),null);
    }
}
