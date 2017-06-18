package com.evbs.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by squirrel-chen on 6/18/17.
 */
@Component
@RabbitListener(queues = "hello")
public class Receiver {


    //接受消息
    @RabbitHandler
    public void receive(String str)
    {
        System.out.println("接受到消息"+str);

    }
}
