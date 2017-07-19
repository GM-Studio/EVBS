package com.evbs.controller;

import com.evbs.pojo.Passwd;
import com.evbs.pojo.Shadow;
import com.evbs.pojo.User;
import com.evbs.service.UserService;
import com.evbs.util.FileUtil;
import com.evbs.util.LogUtil;
import com.evbs.util.SHAUtil;
import org.apache.commons.io.FileUtils;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


        String ROOT_PATH="/home/squirrel-chen/evbs/";
        String USER_PATH=ROOT_PATH+username;
        String PROFILE_PATH=USER_PATH+"/.profile";

        String PASSWD_PATH=ROOT_PATH+"etc/passwd";
     // String SHADOW_PATH=ROOT_PATH+"etc/shadow";

        int USER_ID=0;
        LogUtil.logger.info("创建用户目录"+ FileUtil.createUserDir(USER_PATH));

        int linesnum=FileUtil.countLines(PASSWD_PATH);
        LogUtil.logger.info("用户总数量"+linesnum);
        FileUtil.writeToFile(PROFILE_PATH,username+":"+Integer.valueOf(linesnum+1)+"\n");

        try {
        List<String> result = FileUtils.readLines(new File(PROFILE_PATH), "UTF-8");
        USER_ID=Integer.valueOf(result.get(0).substring(result.get(0).lastIndexOf(":")+1,result.get(0).length()));
        }
        catch(Exception e)
        {
            LogUtil.logger.error("截取错误");
            USER_ID=0;
            e.printStackTrace();
        }

//        String d=FileUtil.readFromFile(PROFILE_PATH);
//        d=d.substring(d.lastIndexOf(":")+1,d.length());
        LogUtil.logger.info("用户记录"+Integer.valueOf(USER_ID));


        /**
         *  创建Passwd对象
         */

        Passwd passwd=new Passwd();
        passwd.setUsername(username);
        passwd.setUid(linesnum+1);
        passwd.setGid(linesnum+1);
        passwd.setPasswd("x");
        passwd.setComment("使用者"+username);
        passwd.setUserpath(ROOT_PATH+username);

        /**
         *  创建 Shadow 对象
         */

        Shadow shadow=new Shadow();
        shadow.setUsername(username);
        shadow.setPassword("");
        shadow.setFlag("true");

        String pawd=username+":x:"+passwd.getUid()+":"+passwd.getGid()+":"+passwd.getComment()+":"+passwd.getUserpath()+"\n";
        String shacode = SHAUtil.shaEncode(password);
        LogUtil.logger.info("加密后的密码"+shacode);
        String shaw=username+":"+shacode+"\n";

        if(userService.register(pawd,shaw))
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