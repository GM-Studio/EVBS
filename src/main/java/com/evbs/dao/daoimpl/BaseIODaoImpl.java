package com.evbs.dao.daoimpl;
import com.evbs.dao.BaseIODao;
import org.springframework.stereotype.Repository;

import java.io.*;

/**
 * Created by squirrel-chen on 7/2/17.
 */
@Repository
public class BaseIODaoImpl implements BaseIODao {


    @Override
    public String fileRead (String filename){
        char buff[]=new char[1024];
        try {
            File inputfile = new File(filename);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(inputfile));
            reader.read(buff,0,(int)inputfile.length());
            reader.close();
        }
        catch (Exception e)
        {
            System.out.println("文件读取失败");
            e.printStackTrace();
        }
        return new String(buff);
    }

    @Override
    public void fileWrite(String filename,String data) {

        try{
            File outputfile=new File(filename);
            OutputStreamWriter writer=new OutputStreamWriter(new FileOutputStream(outputfile));
            writer.write(data.toCharArray(),0,data.length());
            writer.flush();
            writer.close();
        }

        catch(Exception e)
        {
            System.out.println("文件读取失败");
            e.printStackTrace();
        }

    }
}
