package com.sal.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "userMapper")
public interface UserMapper {
    //根据账号查询密码
    String findPassword(String username);

}
