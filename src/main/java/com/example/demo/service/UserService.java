package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @描述： 业务处理层
 * @Author: 小强
 * @Date: 2021/2/8 0008
 * @Tools: IntelliJ IDEA
 * @Remember: Be professional every day
 **/
@Service
public class UserService {
    @Resource
    public UserMapper userMapper;

    public List<User> showAll(){
        return userMapper.findAll();
    }

    public User selectByID(int id){
        return userMapper.selectByID(id);
    }

    public User selectByName(String name){
        return userMapper.selectByName(name);
    }

    public int updateByID(String password,int id){
        return userMapper.updateByID(password,id);
    }

    public int insert(User user){
        return userMapper.insert(user);
    }

}
