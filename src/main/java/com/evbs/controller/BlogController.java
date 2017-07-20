package com.evbs.controller;

import com.evbs.util.LogUtil;
import org.hashids.Hashids;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by squirrel-chen on 7/19/17.
 */
@Controller
public class BlogController {

    @RequestMapping("/blog")
    public String blog(@RequestParam("id")String id){

        Hashids hashids=new Hashids("my salt is pig ",15);
        long[] numbers=hashids.decode(id);
        LogUtil.logger.info("选择的编号是"+numbers[0]);
        return "success";
    }

}
