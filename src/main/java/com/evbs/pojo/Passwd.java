package com.evbs.pojo;

/**
 * Created by squirrel-chen on 7/12/17.
 */
public class Passwd {


    //属性值

    private String username;
    private String passwd;
    private int uid;
    private int gid;
    private String comment;
    private String userpath;
    private String usershell;

    //属性的getter setter 方法

    public String getUsershell() {
        return usershell;
    }

    public void setUsershell(String usershell) {
        this.usershell = usershell;
    }

    public String getUserpath() {
        return userpath;
    }

    public void setUserpath(String userpath) {
        this.userpath = userpath;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString()
    {
        return username+":"+passwd+":"+uid+":"+gid+":"+comment+":"+userpath+":"+usershell+"\n";
    }
}
