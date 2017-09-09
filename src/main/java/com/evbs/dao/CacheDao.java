package com.evbs.dao;


import com.evbs.pojo.User;

/**
 * Created by squirrel-chen on 6/18/17.
 */

public interface CacheDao {

    public void setUser(User user);
    public User getUser(int userid);
    public void testRedis();

//    public boolean viCache(String vidata);
//
//    public boolean viCacheGet();

}
