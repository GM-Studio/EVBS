package com.evbs.dao;

/**
 * Created by squirrel-chen on 7/2/17.
 */
public interface BaseIODao {

   public String fileRead(String filename);
   public void fileWrite(String filename,String data);

}
