package com.guojiyue.demo1.controller;

import com.guojiyue.demo1.entity.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {

    @RequestMapping("/user/list")
    public String userList(Model model) throws Exception{
        model.addAttribute("title","用户列表");
        model.addAttribute("hello","hello spring boot");
        List<User> userList = new ArrayList<>();
        userList.add(new User("小明",25,true));
        userList.add(new User("小红",28,false));
        model.addAttribute("userList",userList);

        return "/user/list";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello23";
    }
}
