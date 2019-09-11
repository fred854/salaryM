package com.sal.service;

import com.sal.pojo.Person;
import com.sal.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PersonService {

    //查询所有员工基础信息
    List<Person> selectPersonAll();

    //添加员工
    String addPerson(Person person);

    //删除员工
    String deletePerson(Integer personId);

    //修改员工
    String updatePerson(Person person);

    //获取员工
    Person getUser(int id);
}
