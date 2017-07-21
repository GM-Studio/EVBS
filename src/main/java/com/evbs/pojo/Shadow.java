package com.evbs.pojo;

import java.util.Date;

/**
 * Created by squirrel-chen on 7/12/17.
 */
public class Shadow {

    //属性值

    private String username;
    private String password;


    //属性的getter setter 方法

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }


    @Override
    public String toString(){
        return username+":"+password+"\n";
    }

}
