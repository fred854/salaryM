package com.sal.Util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
@Aspect
@Component
public class LogUtil {
    private static final Logger logger= LoggerFactory.getLogger(LogUtil.class);

    @Pointcut("execution(public * com.sal.controller.*.*(..))")
    public void webLog() {

    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        //接受到请求，记录请求内容
        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        //记录下请求内容
        logger.info("URL:"+request.getRequestURL().toString());
        logger.info("HTTP_METHOD:"+request.getMethod());
        logger.info("URI:"+request.getRequestURI());
        logger.info("IP:"+request.getRemoteAddr());
        logger.info("method:"+joinPoint.toShortString());
        Enumeration<String> enu=request.getParameterNames();
        while(enu.hasMoreElements()) {
            String name=(String)enu.nextElement();
            logger.info("name:{},value:{}",name,request.getParameter(name));
        }

    }

    @AfterReturning(returning="ret",pointcut="webLog()")
    public void doAfterReturning(Object ret)throws Throwable{
        //处理完请求，返回结果
        logger.info("RESPONE:"+ret);
    }
}
