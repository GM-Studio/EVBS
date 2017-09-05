package com.evbs.controller;

import com.alibaba.fastjson.JSON;
import com.evbs.dao.CacheDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by squirrel-chen on 7/2/17.
 */
@Controller
public class ViController {

//    @Autowired
//    private BaseIOService baseIOService;
//
//    @RequestMapping("/vi")
//    public String vifile()
//    {
//        baseIOService.fileWrite("/home/squirrel-chen/demop.txt","陈皓松 is vary good 我是陈皓松 123 something is wordk djsakflks dflsnfaijfafklsffsadfsdakfnkvsdmfsjfifsfsa" +
//                "dsadklasjdasiodachsajdaskjdas" +
//                "dadjksldjaskdjasljd " +
//                "的撒娇了多久啦开始觉得肯德基开飞机就卡的加快进度款拉升阶段垃圾袋可垃圾的绿卡设计的考虑kkljflsjifjadkasj大家看大家爱思考的金卡即可" +
//                "三大框架的考拉" +
//                "");
//        return "ok";
//    }
//
//    @RequestMapping("/read")
//    public String vv()
//    {
//       return  baseIOService.fileRead("/home/squirrel-chen/demop.txt");
//    }

    @Autowired
    private CacheDao cacheDao;

    @RequestMapping("/vi")
    public String vipage(){return "vipage.html";}

    @RequestMapping("/vipage")
    @ResponseBody
    public String vi(@RequestParam("vidata")String vidata){
        System.out.println("缓冲的数据"+vidata);
        cacheDao.viCache(vidata);
        System.out.println("读取缓存的数据");
        cacheDao.viCacheGet();
        return  String.valueOf(JSON.parse("{'flag':'true'}"));
    }
}
