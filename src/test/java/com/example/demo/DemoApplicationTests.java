package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Value("${age}")
    private int age;

    @Value("${name}")
    private String name;


    @Autowired
    private UserService userService;

    @Test
    void select(){
        User user = userService.selectByID(1);
        System.out.println(user);
    }
    @Test
    void contextLoads() {

    }

    @Test
    public void getAge(){
        System.out.println(age);
    }

    @Test
    public void getName(){
        System.out.println(name);

    }

}
