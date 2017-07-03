package com.evbs.controller;

import com.evbs.service.BaseIOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by squirrel-chen on 7/2/17.
 */
@RestController
public class ViController {

    @Autowired
    private BaseIOService baseIOService;

    @RequestMapping("/vi")
    public String vifile()
    {
        baseIOService.fileWrite("/home/squirrel-chen/demop.txt","陈皓松 is vary good 我是陈皓松 123 something is wordk djsakflks dflsnfaijfafklsffsadfsdakfnkvsdmfsjfifsfsa" +
                "dsadklasjdasiodachsajdaskjdas" +
                "dadjksldjaskdjasljd " +
                "的撒娇了多久啦开始觉得肯德基开飞机就卡的加快进度款拉升阶段垃圾袋可垃圾的绿卡设计的考虑kkljflsjifjadkasj大家看大家爱思考的金卡即可" +
                "三大框架的考拉" +
                "");
        return "ok";
    }

    @RequestMapping("/read")
    public String vv()
    {
       return  baseIOService.fileRead("/home/squirrel-chen/demop.txt");
    }
}
