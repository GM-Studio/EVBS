package com.evbs.controller;

import com.alibaba.fastjson.JSON;
import com.evbs.dao.CacheDao;
import com.evbs.dao.ViDao;
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


//
//    @Autowired
//    private CacheDao cacheDao;

    @Autowired
    private ViDao viDao;

//    @RequestMapping("/vi")
//    public String vipage(){return "vipage.html";}

//    @RequestMapping("/vipage")
//    @ResponseBody
//    public String vi(@RequestParam("vidata")String vidata){
//        System.out.println("缓冲的数据"+vidata);
//        cacheDao.viCache(vidata);
//        System.out.println("读取缓存的数据");
//        cacheDao.viCacheGet();
//        return  String.valueOf(JSON.parse("{'flag':'true'}"));
//    }


    //存入缓存的action

    @ResponseBody
    @RequestMapping("/setvicache")
    public String setcache(@RequestParam("vicache")String vicache) {

        if(viDao.setViCache(vicache)){
            return String.valueOf(JSON.parse("{'flag':'true'}"));
        }
        return String.valueOf(JSON.parse("{'flag':'false'}"));

    }

    //取出缓存的action
    @ResponseBody
    @RequestMapping("/getvicache")
    public String getcache(){

        String str=new String();
        str=viDao.getViCache();
        if(str.equals(""))
        {
            return String.valueOf(JSON.parse("{'data':''}"));
        }
        str="{'data':'"+str+"'}";
        System.out.println("      "+str);
        return String.valueOf(JSON.parse(str));
//        return String.valueOf(JSON.parse("{'data':"+str+"}"));
    }

    //存入文件的action
    @ResponseBody
    @RequestMapping("/setvifile")
    public String setvifile(@RequestParam("vifilepath")String filepath,@RequestParam("vidata")String vidata){

        if(viDao.setViFile(filepath,vidata))
        {
            return String.valueOf(JSON.parse("{'flag':'true'}"));
        }
        return String.valueOf(JSON.parse("{'flag':'false'}"));
    }

}
