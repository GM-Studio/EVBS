package com.evbs.controller;

import com.evbs.util.LogUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by squirrel-chen on 7/19/17.
 */
@Controller
public class BlogController {

    @RequestMapping("/blog")
    public String blog(@RequestParam("no")int no){
        LogUtil.logger.info("选择的编号是"+no);
        return "success";
    }

}
