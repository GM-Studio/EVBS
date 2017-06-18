package com.evbs.pojo;

import java.io.Serializable;

/**
 * Created by squirrel-chen on 6/18/17.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 6177040540788012697L;

    //POJO属性
    private int userid;
    private String username;
    private String password;

    // POJO类属性getter setter 方法
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User()
    {
        super();
    }

    //User的构造方法
    public User(int id,String name,String password)
    {
        this.userid=id;
        this.username=name;
        this.password=password;
    }

    //toString方法
    public String toString()
    {
        return "The user.id is  "+this.userid+" user.name is  "+this.username+" user.pass is  "+this.password;
    }

}
