package com.sal.config;

import com.alibaba.fastjson.JSON;
import com.sal.pojo.Result;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
// 无权访问返回的 JSON 格式数据给前端
@Component
public class AjaxAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        Result res=new Result();
        res.setCode(300);
        res.setMsg("无权访问");
        httpServletResponse.getWriter().write(JSON.toJSONString(res));
    }
}
