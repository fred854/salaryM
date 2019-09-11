package com.sal.service;

import com.sal.dao.UserMapper;
import com.sal.exception.MyException;
import com.sal.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
   private UserMapper userMapper;

    @Override
    public String findPassword(User user) {
        String password=userMapper.findPassword(user.getUsername());
        if(password==null){
          throw new MyException(400,"用户不存在！");
        }else{
            if(!password.equals(user.getPassword())){
                throw new MyException(400,"密码错误！");
            }else{
                return "登录成功！";
            }
        }
    }
}
