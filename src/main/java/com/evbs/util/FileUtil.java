package com.evbs.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by squirrel-chen on 7/12/17.
 */
public class FileUtil {

    public static boolean writeToFile(String filepath,String data)
    {
        File outputfile=new File(filepath);
        try {
            if(!outputfile.exists())
            {
                LogUtil.logger.info("目标文件不存在");
                outputfile.createNewFile();
            }
            FileUtils.writeStringToFile(outputfile,data,"UTF-8");
            return true;
        } catch (IOException e) {
            LogUtil.logger.info("写入文件数据出错");
            e.printStackTrace();
            return false;
        }
    }

    public static String readFromFile(String filepath)
    {
        File inputfile=new File(filepath);
        try{
            if(!inputfile.exists())
            {
                LogUtil.logger.info("目标文件不存在");
                return "";
            }
           return FileUtils.readFileToString(inputfile,"UTF-8");
        }
        catch(IOException e)
        {
            LogUtil.logger.info("读取文件数据出错");
            e.printStackTrace();
            return "";
        }
    }

    public static boolean appendDataToFile(String filepath,String data)
    {
        File appendfile=new File(filepath);
        try{
            if(!appendfile.exists()){
                appendfile.createNewFile();
                LogUtil.logger.info("文件不存在,创建新文件");
            }
            FileUtils.writeStringToFile(appendfile,data,"UTF-8",true);
            return true;
        }
        catch(Exception e)
        {
            LogUtil.logger.info("追加文件数据出错");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean createUserDir(String dirpath)
    {
        File userdir=new File(dirpath);
        try{
            if(!userdir.exists())
            {
                userdir.mkdirs();
                LogUtil.logger.info("创建用户目录");
            }
            return true;
        }
        catch(Exception e)
        {
            LogUtil.logger.info("目录创建失败");
            e.printStackTrace();
            return false;
        }
    }

    public static int countLines(String filepath)
    {
        File countfile=new File(filepath);
        try{

            if(!countfile.exists())
            {
            LogUtil.logger.info("目标文件不存在");
            return 0;
            }
           return (FileUtils.readLines(countfile,"UTF-8")).size();
        }
        catch(Exception e)
        {
            LogUtil.logger.error("统计文件行数异常");
            e.printStackTrace();
        }
        return 0;
    }

}
