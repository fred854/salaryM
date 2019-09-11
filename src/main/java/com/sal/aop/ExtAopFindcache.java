package com.sal.aop;
import com.alibaba.fastjson.JSONObject;
import com.sal.Util.EhcacheUtils;
import com.sal.Util.RedisService;
import com.sal.ext.ExtFindcache;
import com.sal.pojo.Person;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Aspect
@Component
public class ExtAopFindcache {

    @Autowired
    private EhcacheUtils ehcacheUtils;

    @Autowired
    private RedisService redisService;

    @Pointcut("execution(public * com.sal.controller.*.*(..))")
    public void findcache() {
    }

    @Around("findcache()")
    public Object doBefore(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature=(MethodSignature)proceedingJoinPoint.getSignature();
        ExtFindcache declaredAnnotation= (ExtFindcache) methodSignature.getMethod().getDeclaredAnnotation(ExtFindcache.class);

        if(declaredAnnotation!=null){
            String partKeyname=declaredAnnotation.partKeyname();
            int partKeyId=declaredAnnotation.partKeyId();
            String cacheName=declaredAnnotation.cacheName();
            //获取方法返回类型
            Class returnType = methodSignature.getReturnType();

            String key = this.getClass().getName() + "-" + Thread.currentThread().getStackTrace()[1].getMethodName()
                    + "-" + partKeyname+":"+partKeyId;

            // 1.先查找一级缓存(本地缓存),如果本地缓存有数据直接返回
            Object ehUser =ehcacheUtils.get(cacheName, key);
            if (ehUser != null) {
                System.out.println("使用key:" + key + ",查询一级缓存 ehCache 获取到ehUser:" +ehUser.toString());
                return ehUser;
            }
            // 2. 如果本地缓存没有该数据，直接查询二级缓存(redis)
            String userJSON=redisService.getString(key);
            if(!StringUtils.isEmpty(userJSON)){
                //将JSON转换为对象（如果二级缓存redis中有数据直接返回二级缓存,更新一级缓存）
                JSONObject jsonObject=new JSONObject();
                Object user=jsonObject.parseObject(userJSON,returnType);
                ehcacheUtils.put(cacheName,key,user);
                System.out.println("使用key:" + key + ",查询二级缓存 redis 获取到ehUser:" + JSONObject.toJSONString(user));
                return user;
            }

        }
        //放行
        Object proceed=proceedingJoinPoint.proceed();
        return proceed;
    }
}
