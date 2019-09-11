package com.sal.config;

import com.alibaba.fastjson.JSON;
import com.sal.pojo.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//  未登陆时返回 JSON 格式的数据给前端
@Component
public class AjaxAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        Result res=new Result();
        res.setCode(000);
        res.setMsg("未登录");
        httpServletResponse.getWriter().write(JSON.toJSONString(res));
    }
}
