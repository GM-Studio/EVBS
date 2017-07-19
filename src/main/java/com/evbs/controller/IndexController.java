package com.evbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by squirrel-chen on 7/9/17.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index()
    {
//        model.addAttribute("hello"," you are pig is world");
        return "index";
    }

    @RequestMapping("/page")
    public String page(){
        return "page";
    }
}
