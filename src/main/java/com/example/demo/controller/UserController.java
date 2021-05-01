package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @描述： 控制访问层
 * @Author: 小强
 * @Date: 2021/2/8 0008
 * @Tools: IntelliJ IDEA
 * @Remember: Be professional every day
 **/
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /*
    * 显示所有用户
    * */
    @RequestMapping("/findAll")
    @ResponseBody
    public Object showAll(){
        return userService.showAll();
    }

    /*
    * 根据id查询用户
    * */
    @RequestMapping("/findByID/{id}")
    @ResponseBody
    public User findByID(@PathVariable("id") int id){
        User user = userService.selectByID(id);
        return user;
    }

    /*
    * 根据id更新密码
    * */
    @RequestMapping("/updateByID/{id}/{password}")
    public int updateByID(@PathVariable("id") int id,@PathVariable("password") String password){
        int row = userService.updateByID(password, id);
        return row;
    }

    /*
    * 根据名字查询用户
    * */
    @RequestMapping("/findByName/{name}")
    @ResponseBody
    public User selectByName(@PathVariable("name") String name){
        User user = userService.selectByName(name);
        return user;
    }

    //登录
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/loginSuccess")
    public String loginSuccess(Model model, User user) {
        //查询用户名是否存在
        User user1 = userService.selectByName(user.getName());
        if (user1 != null) { //如果用户名存在
            if (user1.getPassword().equals(user.getPassword())) {
                System.out.println(user1.toString());
                return "success";
            } else {
                model.addAttribute("data", "密码不正确");
                return "login";
            }

        } else { //用户名不存在，直接返回到登录页面
            model.addAttribute("data", "该用户不存在，请先注册");
            return "login";
        }
    }


    //注册
    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/toRegisterSuccess")
    public String toRegisterSuccess(Model model, User user, HttpServletRequest request) {
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        if (password.equals(password2)) {
            //添加一条记录到数据库中
            int add = userService.insert(user);
            System.out.println("插入数据成功");
            model.addAttribute("data", "注册成功，请登录");
            return "login";
        } else {
            model.addAttribute("data","确认密码与原密码不一样");
            return "register";
        }
    }

}
