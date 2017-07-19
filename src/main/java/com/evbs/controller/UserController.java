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

    private  String ROOT_PATH="/home/squirrel-chen/evbs/";
    private  String PASSWD_PATH=ROOT_PATH+"etc/passwd";
    private  String SHADOW_PATH=ROOT_PATH+"etc/shadow";

    @RequestMapping("/test")
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

    /**
     * function for login
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(@RequestParam("username")String username,@RequestParam("password")String password)
    {
        String USER_PATH=ROOT_PATH+username;
        String PROFILE_PATH=USER_PATH+"/.profile";
        LogUtil.logger.info("登录的用户名和密码"+username+"...."+password);

        //从文件中截取得到对应用户所在的行数

        int USER_ID=0;
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

        String readdata= FileUtil.readDataByLineNumber(SHADOW_PATH,USER_ID);
        readdata=readdata.substring(readdata.lastIndexOf(":")+1,readdata.length());
        // 将登录的密码和加密的密码进行比对
        String encodepw=SHAUtil.shaEncode(password);
        if(encodepw.equals(readdata))
        {
            LogUtil.logger.info("密码验证正确");
            return "success";
        }
        else
        {
            LogUtil.logger.error("密码验证错误");
            return "failure";
        }
    }

    /**
     * function for register
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value="/register",method=RequestMethod.POST)
    public String register(@RequestParam("username")String username,@RequestParam("password")String password)
    {

        String USER_PATH=ROOT_PATH+username;
        String PROFILE_PATH=USER_PATH+"/.profile";
        LogUtil.logger.info("创建用户目录"+ FileUtil.createUserDir(USER_PATH));

        //统计已存在用户的数目

        int linesnum=FileUtil.countLines(PASSWD_PATH);
        LogUtil.logger.info("用户总数量"+linesnum);
        FileUtil.writeToFile(PROFILE_PATH,username+":"+Integer.valueOf(linesnum+1)+"\n");

        /**
         * 此处不知道应该写入对象还是拼接字符串写入文件？？？
         */

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
        String shaw=username+":"+shacode+"\n";

        if(userService.register(pawd,shaw))
        {
          return "success";
        }
        return "failure";
    }

    /**
     *  user page
     * @return
     */

    @RequestMapping(value="/user")
    public String userpage()
    {
        return "user";
    }
}