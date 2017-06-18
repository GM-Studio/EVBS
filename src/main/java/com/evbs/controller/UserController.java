package com.evbs.controller;

import com.evbs.pojo.User;
import com.evbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by squirrel-chen on 6/18/17.
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/com/evbs/test")
    public String testuser()
    {

        User user=new User(2,"zh","123456");
        System.out.println("设置对象存储redis");
        userService.setUser(user);
        System.out.println("获取redis存储的对象");
        userService.getUser(2);
        return "ok";
    }

    @RequestMapping("/demo")
    public String testredis()
    {

        userService.testRedis();
        return "WELL";
    }
}