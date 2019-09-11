package com.sal.Util;

import com.github.pagehelper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

//如何生成token
@Component
public class RedisToken {

    @Autowired
    private RedisService baseRedisService;
    private static final long TOKENTIMROUT=60*60;

    public String getToken(){
        //生成token 规则保证 临时且唯一 不支持分布式场景（分布式全局ID生成规则）
        String token="token"+ UUID.randomUUID();
        //如何保证token临时（缓存） 使用redis实现缓存
        baseRedisService.set(token,token,TOKENTIMROUT);
        return token;
    }

    public boolean findToken(String tokenKey){
       String tokenValu= baseRedisService.getString(tokenKey);
       if(StringUtil.isEmpty(tokenKey)){
           return false;
       }
        baseRedisService.delKey(tokenKey);
       return true;
    }

    public boolean deleteToken(String tokenKey){
        return baseRedisService.delKey(tokenKey);
    }

}
