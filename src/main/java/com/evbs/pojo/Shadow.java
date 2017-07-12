package com.evbs.pojo;

import java.util.Date;

/**
 * Created by squirrel-chen on 7/12/17.
 */
public class Shadow {

    //属性值

    private String username;
    private String password;
    private Date lastchg;
    private Date min;
    private Date max;
    private Date warn;
    private Date inactive;
    private Date expire;
    private String flag;

    //属性的getter setter 方法

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public Date getInactive() {
        return inactive;
    }

    public void setInactive(Date inactive) {
        this.inactive = inactive;
    }

    public Date getWarn() {
        return warn;
    }

    public void setWarn(Date warn) {
        this.warn = warn;
    }

    public Date getMax() {
        return max;
    }

    public void setMax(Date max) {
        this.max = max;
    }

    public Date getMin() {
        return min;
    }

    public void setMin(Date min) {
        this.min = min;
    }

    public Date getLastchg() {
        return lastchg;
    }

    public void setLastchg(Date lastchg) {
        this.lastchg = lastchg;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
