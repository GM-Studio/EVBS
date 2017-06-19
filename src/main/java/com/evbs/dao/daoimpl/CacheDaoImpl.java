package com.evbs.dao.daoimpl;

import com.evbs.dao.CacheDao;
import com.evbs.dao.UserDao;
import com.evbs.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by squirrel-chen on 6/19/17.
 */
@Component
public class CacheDaoImpl implements CacheDao {


    @Autowired
    private UserDao userDao;

    @Override
    public void setUser(User user) {
        userDao.setUser(user);
    }

    @Override
    public User getUser(int userid) {
        return userDao.getUser(userid);
    }

    @Override
    public void testRedis() {
        userDao.testRedis();
    }
}
