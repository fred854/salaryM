package com.sal.Util;

import com.sal.exception.MyException;
import com.sal.pojo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(basePackages="com.sal.controller")
public class ExcptionHandleUtil {
    private final static Logger logger = LoggerFactory.getLogger(ExcptionHandleUtil.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {

        if(e instanceof MyException) {
            MyException myException = (MyException)e;;
            return  ResultUtil.error(myException.getCode(),myException.getMsg());
        }

        else {
            logger.error("{系统异常} { }",e);
            return ResultUtil.error(-1, "未知错误");
        }

    }
}
