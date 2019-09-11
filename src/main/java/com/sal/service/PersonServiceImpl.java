package com.sal.service;

import com.alibaba.fastjson.JSONObject;
import com.sal.Util.EhcacheUtils;
import com.sal.Util.RedisService;
import com.sal.dao.PersonMapper;
import com.sal.exception.MyException;
import com.sal.pojo.Person;
import com.sal.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.util.List;
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private EhcacheUtils ehcacheUtils;

    private String cacheName="userCache";
    @Autowired
    private RedisService redisService;


    @Autowired
     private PersonMapper personMapper;

    @Override
    public List<Person> selectPersonAll() {
        List<Person> list=personMapper.selectPersonAll();
        return list;
    }

    @Override
    public String addPerson(Person person) {
        Integer id=personMapper.addPerson(person);
        if(id==0||id==null){
            throw new MyException(500,"添加失败！");
        }
        return "添加成功！";
    }

    @Override
    public String deletePerson(Integer personId) {
        Integer id=personMapper.deletePerson(personId);
        if(id==0||id==null){
            throw new MyException(500,"删除失败！");
        }
        return "删除成功！";
    }

    @Override
    public String updatePerson(Person person) {
        Integer id=personMapper.updatePerson(person);
        if(id==0||id==null){
            throw new MyException(500,"修改失败！");
        }
        return "修改成功！";

    }

    public Person getUser(int id){
        String key = this.getClass().getName() + "-" + Thread.currentThread().getStackTrace()[1].getMethodName()
                + "-id:" + id;
        // 1.先查找一级缓存(本地缓存),如果本地缓存有数据直接返回
        Person ehUser = (Person) ehcacheUtils.get(cacheName, key);
        if (ehUser != null) {
            System.out.println("使用key:" + key + ",查询一级缓存 ehCache 获取到ehUser:" +ehUser.toString());
            return ehUser;
        }

        // 2. 如果本地缓存没有该数据，直接查询二级缓存(redis)
        String userJSON=redisService.getString(key);
        if(!StringUtils.isEmpty(userJSON)){
            //将JSON转换为对象（如果二级缓存redis中有数据直接返回二级缓存,更新一级缓存）
            JSONObject jsonObject=new JSONObject();
            Person user=jsonObject.parseObject(userJSON,Person.class);
            ehcacheUtils.put(cacheName,key,user);
            System.out.println("使用key:" + key + ",查询二级缓存 redis 获取到ehUser:" + JSONObject.toJSONString(user));
            return user;

        }
        // 3. 如果二级缓存redis中也没有数据,查询数据库1
        Person user=personMapper.getPerson(id);
        if(user==null){
           throw new MyException(500,"获取失败！");
        }
        //如何保证两级缓存有效期相同，时差问题
        //更新一级和二级缓存
        String userjson=JSONObject.toJSONString(user);
        redisService.setString(key,userjson);
        ehcacheUtils.put(cacheName,key,user);
        System.out.println("使用key:" + key + "，一级缓存和二级都没有数据,直接查询db" + userjson);
        return user;
    }
}
