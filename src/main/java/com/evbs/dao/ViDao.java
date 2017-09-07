package com.evbs.dao;

/**
 * Created by squirrel-chen on 9/2/17.
 */
public interface ViDao {

    public boolean setViCache(String vicache);

    public String getViCache();

    public boolean setViFile(String filepath,String vifile);

    public String getViFile(String filepath);

}
