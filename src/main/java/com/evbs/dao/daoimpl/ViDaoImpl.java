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
    public boolean setViCache(String vicache) {
        try{

            redisTemplate.opsForValue().set("vicache",vicache);
            logger.info("存入缓存数据"+vicache);
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getViCache() {
        String str=new String();
        try{

            str=String.valueOf(redisTemplate.opsForValue().get("vicache"));
            logger.info("取出缓存的数据"+str);
            return str;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            str="error";
        }
        return str;
    }

    @Override
    public boolean setViFile(String vifile) {
        return false;
    }

    @Override
    public String getViFile() {
        return null;
    }
}
