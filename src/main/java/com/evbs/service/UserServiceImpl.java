package com.evbs.service;

import com.evbs.dao.UserDao;
import com.evbs.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by squirrel-chen on 6/18/17.
 */
@Service
public class UserServiceImpl  implements  UserService{


    @Autowired
    private UserDao userDao;

    @Override
    public void setUser(User user) {
        userDao.setUser(user);
    }

    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    public void testRedis() {
        userDao.testRedis();
    }
}

