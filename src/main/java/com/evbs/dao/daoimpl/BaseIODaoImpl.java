package com.evbs.dao.daoimpl;
import com.evbs.dao.BaseIODao;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.stereotype.Repository;

import java.io.*;

/**
 * Created by squirrel-chen on 7/2/17.
 */
@Repository
public class BaseIODaoImpl implements BaseIODao {


    @Override
    public String fileRead (String filename){

        String str=new String();
        StringBuilder sb=new StringBuilder();
        try {
            File inputfile = new File(filename);
            if (!inputfile.exists())
            {
                System.out.println("文件不存在");
                return "";
            }
            BufferedReader reader=new BufferedReader(new FileReader(inputfile));
            while((str=reader.readLine())!=null)
            {
                sb.append(str+"\n");
            }
            str=sb.toString();
            reader.close();
        }
        catch (Exception e)
        {
            System.out.println("文件读取失败");
            e.printStackTrace();
        }
        return str;
    }

    @Override
    public boolean fileWrite(String filename,String data) {

        try{

            File outputfile=new File(filename);
            if(!outputfile.exists())
            {
                outputfile.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputfile,true));
            writer.write(data+"\n");
            writer.flush();
            writer.close();
            return true;
        }

        catch(Exception e)
        {
            System.out.println("文件读取失败");
            e.printStackTrace();
        }

        return false;
    }
}
