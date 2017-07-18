package com.evbs.controller;

import com.evbs.pojo.Passwd;
import com.evbs.pojo.Shadow;
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

import java.util.Date;

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
    public String login(@RequestParam("username")String username,@RequestParam("password")String password)
    {
        LogUtil.logger.info("登录的用户名和密码"+username+"...."+password);


//
//        if(userService.login(user))
//        {
//            return "success";
//        }
        return  "failure";
    }

    @RequestMapping(value="/register",method=RequestMethod.POST)
    public String register(@RequestParam("username")String username,@RequestParam("password")String password)
    {
        LogUtil.logger.info("登录的用户名和密码"+username+"...."+password);

//        /**
//         *  创建Passwd对象
//         */
//
//        Passwd passwd=new Passwd();
//        passwd.setUsername(username);
//        passwd.setUid(1);
//        passwd.setGid(1);
//        passwd.setPasswd("x");
//        passwd.setComment("使用者"+username);
//        passwd.setUsershell("");
//        passwd.setUserpath("");
//
//        /**
//         *  创建 Shadow 对象
//         */
//
//        Shadow shadow=new Shadow();
//        shadow.setUsername(username);
//        shadow.setPassword("");
//        shadow.setFlag("true");
//        shadow.setMin(new Date());
//        shadow.setMax(new Date());
//        shadow.setExpire(new Date());
//        shadow.setWarn(new Date());
//        shadow.setInactive(new Date());
//        shadow.setLastchg(new Date());

        String passwd=username+":"+"x:"+"1:"+"1:"+"使用者"+username+":"+"路径"+""+":"+"bash";
        String shadow=username+":"+"hashid:"+"17329:"+"0:"+"99999:"+"7:::";

        if(userService.register(passwd,shadow))
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