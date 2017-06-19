package servicetest;

import com.evbs.dao.UserDao;
import com.evbs.MainApplication;
import com.evbs.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by squirrel-chen on 6/18/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MainApplication.class)
public class UserServiceTest {


    @Autowired
    private UserDao userDao;

    @Test
    public void testService()
    {
        User user=new User(3,"hello","123");
        userDao.setUser(user);
        Assert.assertEquals(3,userDao.getUser(3).getUserid());
        Assert.assertEquals("hello",userDao.getUser(3).getUsername());
        Assert.assertEquals("123",userDao.getUser(3).getPassword());
    }

}