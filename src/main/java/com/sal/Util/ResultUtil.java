package com.sal.Util;

import com.sal.pojo.Result;

public class ResultUtil {

    public static Result success(String msg,Object object){
        Result result=new Result();
        result.setCode(200);
        result.setMsg(msg);
        result.setObject(object);
        return result;
    }

    public static  Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
