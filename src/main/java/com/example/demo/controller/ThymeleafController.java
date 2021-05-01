package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @描述：
 * @Author: 小强
 * @Date: 2021/3/11 0011
 * @Tools: IntelliJ IDEA
 * @Remember: Be professional every day
 **/
@Controller
public class ThymeleafController {
    /**
     * Description: 这是一个控制器
     **/
    @RequestMapping("/demo")
    public String demo(Model model) throws Exception{
        model.addAttribute("t","这是标题");
        model.addAttribute("mav","大家好，我是Thymeleaf");
        model.addAttribute("name","杨小强");
        model.addAttribute("role","admin");
        return "demo";
    }
}
