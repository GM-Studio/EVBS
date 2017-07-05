package com.evbs.service;

import com.evbs.pojo.User;

/**
 * Created by squirrel-chen on 6/18/17.
 */
public interface UserService {

    public void setUser(User user);
    public User getUser(int userid);
    public void testRedis();
    public boolean login(User user);
    public boolean register(User user);
}
