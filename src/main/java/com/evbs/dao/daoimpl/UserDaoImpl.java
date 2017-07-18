package com.evbs.dao.daoimpl;

import com.evbs.dao.UserDao;
import com.evbs.pojo.User;
import com.evbs.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by squirrel-chen on 6/18/17.
 */

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public void setUser(User user) {
        redisTemplate.opsForValue().set("user",user);
        System.out.println("存储对象到redis里");
    }

    @Override
    public User getUser(int id) {
        System.out.println("获取存储在redis的对象");
        System.out.println(((User) redisTemplate.opsForValue().get("user")).toString());
        return (User) redisTemplate.opsForValue().get("user");
    }

    @Override
    public void testRedis() {

        //-----------------------字符串测试-------------------------------------------//
        System.out.println("开始测试字符串");
        redisTemplate.delete("hello");
        System.out.println("存入字符串");
        redisTemplate.opsForValue().set("hello","World");
        System.out.println("获取字符串");
        System.out.println("获取的redis 字符串"+redisTemplate.opsForValue().get("hello"));
        redisTemplate.delete("hello");
        //----------------------字符串测试结束--------------------------------------//
        //-----------------------list 测试-----------------------------------------//
        System.out.println("开始测试list");
        redisTemplate.delete("mylist");
        System.out.println("存入list");
        List<String> list=new ArrayList<String>();
        list.add("hello");
        list.add("world");
        list.add("squirrel");
        list.add("chen");
        redisTemplate.opsForList().leftPush("mylist",list.get(0));
        redisTemplate.opsForList().leftPush("mylist",list.get(1));
        redisTemplate.opsForList().rightPush("mylist",list.get(2));
        redisTemplate.opsForList().rightPush("mylist",list.get(3));
        System.out.println("获取list");
        List result= redisTemplate.opsForList().range("mylist",0,-1);
        for(Object o:result)
        {
            System.out.println((String)o);
        }
        redisTemplate.delete("mylist");
        //-----------------------list测试结束--------------------------------------//
        //------------------------set 测试-----------------------------------------//
        System.out.println("开始测试set");
        redisTemplate.delete("myset");
        Set<String> set=new HashSet<String>();
        set.add("xiaomi");
        set.add("huawei");
        set.add("iphone");
        set.add("meizu");
        System.out.println("存储set");
        redisTemplate.opsForSet().add("myset",set);
        System.out.println("获取set");
        Set myset=redisTemplate.opsForSet().members("myset");
        Iterator iterator=myset.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        redisTemplate.delete("myset");
        //----------------------set 测试结束---------------------------------------//
        //----------------------hash测试------------------------------------------//
        System.out.println("开始测试hash");
        redisTemplate.delete("myhash");
        Map hashmap=new HashMap();
        System.out.println("存放hash");
        hashmap.put("some","thing");
        hashmap.put("else","thing");
        redisTemplate.opsForHash().putAll("myhash",hashmap);
        System.out.println("获取hash");
        Map<Object,Object> resultm= redisTemplate.opsForHash().entries("myhash");
        for (Map.Entry entry:resultm.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        redisTemplate.delete("myhash");
        //-----------------------hash 测试结束------------------------------------//
    }

    @Override
    public boolean login(User user) {
        String passwdpath="/home/squirrel-chen/evbs/passfile.json";
        String data= FileUtil.readFromFile(passwdpath);
        if(data.equals(""))
        {
            System.out.println("无数据文件读取");
            return false;
        }
        System.out.println("读取的数据"+data);
        return true;
    }

    @Override
    public boolean register(User user) {
        String passwdpath="/home/squirrel-chen/evbs/passfile.json";
        String userinfo="UserId:"+"     "+user.getUserid()+"UserName:"+"     "+user.getUsername()+"PassWord:"+"     "+user.getPassword();
        if(FileUtil.writeToFile(passwdpath,userinfo)==1){
        return true;
        }
        return false;
    }
}
