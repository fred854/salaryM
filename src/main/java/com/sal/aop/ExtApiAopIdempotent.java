package com.sal.aop;

import com.sal.Util.ConstantUtils;
import com.sal.Util.RedisToken;
import com.sal.exception.MyException;
import com.sal.ext.ExtApiIdempotent;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Aspect
@Component
public class ExtApiAopIdempotent {
    @Autowired
    private RedisToken redisToken;

    @Pointcut("execution(public * com.sal.controller.*.*(..))")
    public void rlAop() {
    }

    @Around("rlAop()")
    public Object doBefore(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        //使用aop环绕通知拦截所有访问（controller）
        MethodSignature methodSignature=(MethodSignature)proceedingJoinPoint.getSignature();
        ExtApiIdempotent declaredAnnotation=methodSignature.getMethod().getDeclaredAnnotation(ExtApiIdempotent.class);
        //调用接口时，获取请求头的令牌
        if(declaredAnnotation!=null){
            String type=declaredAnnotation.type();
            if(type.isEmpty()){
                type= ConstantUtils.EXTAPIHEAD;
            }
            String token=null;
            HttpServletRequest request=getRequest();
            if(type.equals(ConstantUtils.EXTAPIHEAD)){
                token=request.getHeader("token");
            }else {
                token= request.getParameter("token");
            }

            if(StringUtils.isEmpty(token)){
                throw new MyException(500,"添加失败！");
            }
            //如果能够从redis获取到这个令牌，就删掉这个令牌
            boolean isToken=redisToken.findToken(token);
            if(!isToken){
                throw new MyException(500,"请勿重复提交！");
            }
        }
        //放行
        Object proceed=proceedingJoinPoint.proceed();
        return proceed;
    }




    public HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return request;
    }

    public void response(String msg) throws IOException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = attributes.getResponse();
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        try {
            writer.println(msg);
        } catch (Exception e) {

        } finally {
            writer.close();
        }

    }


}
