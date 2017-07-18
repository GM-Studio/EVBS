package com.evbs.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

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
                System.out.println("文件不存在");
                outputfile.createNewFile();
            }
            FileUtils.writeStringToFile(outputfile,data,"UTF-8");
            return true;
        } catch (IOException e) {
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
                System.out.println("文件不存在");
                return "";
            }
           return FileUtils.readFileToString(inputfile,"UTF-8");
        }
        catch(IOException e)
        {
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
            }
            FileUtils.writeStringToFile(appendfile,data,"UTF-8",true);
            return true;
        }
        catch(Exception e)
        {
            System.out.println("文件不存在");
            e.printStackTrace();
            return false;
        }
    }

}
