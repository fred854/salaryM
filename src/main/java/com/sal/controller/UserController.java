package com.sal.controller;

import com.sal.Util.ResultUtil;
import com.sal.pojo.Result;
import com.sal.pojo.User;
import com.sal.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@Api(value = "UserController|用户相关操作接口")
@RequestMapping(value = "salarym/user")
public class UserController {
    @Autowired
   private UserService userService;

    //登录
    @RequestMapping(value="/login",method= RequestMethod.POST)
    @ApiOperation(value="登录验证", notes="登录验证")
    public Result login(@RequestBody User user, HttpServletRequest request)throws Exception{
        System.out.println(user);
        String msg=userService.findPassword(user);
        HttpSession sessoin=request.getSession();//session的创建
        sessoin.setAttribute("username",user.getUsername());
        String username=(String)sessoin.getAttribute("username");
        return ResultUtil.success(msg,user.getUsername());

    }



}
