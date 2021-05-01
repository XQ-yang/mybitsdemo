package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @描述： 通过注解方式访问数据库
 * @Author: 小强
 * @Date: 2021/2/8 0008
 * @Tools: IntelliJ IDEA
 * @Remember: Be professional every day
 **/
@Mapper
public interface UserMapper {
    //查询所有
    @Select("select * from user")
    List<User> findAll();

    //根据id查询
    @Select("select * from user where id = #{id}")
    User selectByID(int id);

    //根据名字查询
    @Select("select * from user where name = #{name}")
    User selectByName(String name);

    //根据id更新
    @Update("update user set password = #{password} where id = #{id}")
    int updateByID(String password,int id);

    //插入
    @Insert("insert into user(name,password) values (#{name},#{password})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insert(User user);


}
