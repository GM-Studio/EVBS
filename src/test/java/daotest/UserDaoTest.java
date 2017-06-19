package daotest;

import com.evbs.MainApplication;
import com.evbs.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by squirrel-chen on 6/18/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MainApplication.class)
public class UserDaoTest {


    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void testDao()
    {
        User user=new User(3,"he","123");
        System.out.println("放入缓存");
        redisTemplate.opsForValue().set("user",user);
        System.out.println("取出数据");
        Assert.assertEquals(3,((User)redisTemplate.opsForValue().get("user")).getUserid());
        Assert.assertEquals("he",((User)redisTemplate.opsForValue().get("user")).getUsername());
        Assert.assertEquals("123",((User)redisTemplate.opsForValue().get("user")).getPassword());
    }

}