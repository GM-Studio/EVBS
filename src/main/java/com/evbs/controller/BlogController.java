package com.evbs.controller;

import org.hashids.Hashids;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by squirrel-chen on 7/19/17.
 */
@Controller
public class BlogController {

    private static final Logger logger= LoggerFactory.getLogger(BlogController.class);

    @RequestMapping("/blog")
    public String blog(@RequestParam("id")String id){

        Hashids hashids=new Hashids("my salt is pig ",15);
        long[] numbers=hashids.decode(id);
        logger.info("选择的编号"+numbers[0]);
        return "success";
    }

}
