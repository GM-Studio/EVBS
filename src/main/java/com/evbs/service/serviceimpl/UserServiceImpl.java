package com.evbs.service.serviceimpl;

import com.evbs.dao.CacheDao;
import com.evbs.dao.UserDao;
import com.evbs.pojo.User;
import com.evbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by squirrel-chen on 6/18/17.
 */
@Service
public class UserServiceImpl  implements UserService {



    @Autowired
    private CacheDao cacheDao;
    @Autowired
    private UserDao userDao;

    @Override
    public void setUser(User user) {
        cacheDao.setUser(user);
    }

    @Override
    public User getUser(int id) {
        return cacheDao.getUser(id);
    }

    @Override
    public void testRedis() {
        cacheDao.testRedis();
    }

    @Override
    public int login(User user) {
        return userDao.login(user);
    }

    @Override
    public int register(User user) {
        return userDao.register(user);
    }
}

