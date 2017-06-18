package com.evbs.util;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by squirrel-chen on 6/18/17.
 */
@Configuration
public class RabbitmqConfig {

    //创建队列
    @Bean
    public Queue helloqueue(){
        return new Queue("hello");
    }
}
