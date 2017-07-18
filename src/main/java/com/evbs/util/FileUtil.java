package com.evbs.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by squirrel-chen on 7/12/17.
 */
public class FileUtil {

    public static int writeToFile(String filepath,String data)
    {
        File outputfile=new File(filepath);
        try {
            if(!outputfile.exists())
            {
                System.out.println("文件不存在");
                outputfile.createNewFile();
            }
            FileUtils.writeStringToFile(outputfile,data);
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
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


}
