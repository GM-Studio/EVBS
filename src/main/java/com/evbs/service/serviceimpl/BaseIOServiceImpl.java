package com.evbs.service.serviceimpl;

import com.evbs.dao.BaseIODao;
import com.evbs.service.BaseIOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by squirrel-chen on 7/2/17.
 */

@Service
public class BaseIOServiceImpl implements BaseIOService{

    @Autowired
    private BaseIODao baseIODao;

    @Override
    public String  fileRead(String filename) {
      return baseIODao.fileRead(filename);
    }
    @Override
    public void fileWrite(String filename,String data) {
        baseIODao.fileWrite(filename,data);
    }
}
