package com.evbs.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by squirrel-chen on 6/18/17.
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    //发送消息
    public void send()
    {
        String context="Hello World "+new Date();
        System.out.println("发送消息"+context);
        amqpTemplate.convertAndSend("hello",context);
    }

}
