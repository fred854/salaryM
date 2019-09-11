package com.sal.config;

import com.alibaba.fastjson.JSON;
import com.sal.pojo.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//  登录失败返回的 JSON 格式数据给前端
@Component
public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        Result res=new Result();
        res.setCode(400);
        res.setMsg("登录失败");
        httpServletResponse.getWriter().write(JSON.toJSONString(res));
    }
}
