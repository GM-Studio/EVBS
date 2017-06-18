package com.evbs.test;


import com.evbs.MainApplication;
import com.evbs.mq.Sender;
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
public class RabbitmqTest {


    @Autowired
    private Sender sender;

    @Test
    public void send()
    {
        sender.send();
    }


}