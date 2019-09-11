package com.sal.config;

import com.alibaba.fastjson.JSON;
import com.sal.pojo.Result;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
// 注销成功返回的 JSON 格式数据给前端
@Component
public class AjaxLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        Result res=new Result();
        res.setCode(200);
        res.setMsg("注销成功");
        httpServletResponse.getWriter().write(JSON.toJSONString(res));
    }
}
