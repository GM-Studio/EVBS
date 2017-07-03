package com.evbs.service;

/**
 * Created by squirrel-chen on 7/2/17.
 */
public interface BaseIOService {

    public String fileRead(String filename);

    public void fileWrite(String filename,String data);


}
