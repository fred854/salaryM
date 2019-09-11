package com.sal.dao;

import com.sal.pojo.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component("PersonMapper")
@CacheConfig(cacheNames = "personCache")
public interface PersonMapper {

    //查询所有员工基础信息
    @Cacheable
    List<Person> selectPersonAll();

    //添加员工
    Integer addPerson(Person person);

    //删除员工
    Integer deletePerson(Integer personId);

    //修改员工
    Integer updatePerson(Person person);

    //查询一个员工信息
    Person getPerson(Integer id);

}
