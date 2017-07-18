package com.evbs.controller;

import com.evbs.pojo.User;
import com.evbs.service.UserService;
import com.evbs.util.LogUtil;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by squirrel-chen on 6/18/17.
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

//    @RequestMapping("/test")
//    public String testuser()
//    {
//
//        User user=new User(2,"zh","123456");
//        System.out.println("设置对象存储redis");
//        userService.setUser(user);
//        System.out.println("获取redis存储的对象");
//        userService.getUser(2);
//        return "ok";
//    }
//
//    @RequestMapping("/demo")
//    public String testredis()
//    {
//        userService.testRedis();
//        return "WELL";
//    }

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(User user)
    {
        LogUtil.logger.info("登录的用户名和密码"+user.getUsername()+"...."+user.getPassword());
        if(userService.login(user))
        {
            return "success";
        }
        return  "failure";
    }

    @RequestMapping(value="/register",method=RequestMethod.POST)
    public String register(User user)
    {
        LogUtil.logger.info("登录的用户名和密码"+user.getUsername()+"...."+user.getPassword());
        if(userService.register(user))
        {
          return "success";
        }
        return "failure";
    }

    @RequestMapping(value="/user")
    public String userpage()
    {
        return "user";
    }
}