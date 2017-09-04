package com.evbs.dao.daoimpl;

import com.evbs.dao.ViDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by squirrel-chen on 9/2/17.
 */
@Repository
public class ViDaoImpl implements ViDao {

    private static final Logger logger= LoggerFactory.getLogger(ViDaoImpl.class);

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public boolean ViCache(String vidata) {
        redisTemplate.opsForValue().set("vi",vidata);
        logger.info("编辑数据存入缓存");
        return true;
    }

    @Override
    public boolean ViCacheGet(){
        String data=String.valueOf(redisTemplate.opsForValue().get("vi"));
        logger.info("获取缓存的数据"+data);
        return true;
    }
}
