package com.sal.service;

import com.sal.pojo.User;

public interface UserService {
    //查询密码
    String findPassword(User user);
}
