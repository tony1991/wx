package com.alibaba.wx.model;

/**
 * @Desc:
 * @Author: tony
 * @Date: Created in 17/7/4 下午3:06  
 */
public class Config {
    private int id;
    private String cfgKey;
    private String cfgValue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCfgKey() {
        return cfgKey;
    }

    public void setCfgKey(String cfgKey) {
        this.cfgKey = cfgKey;
    }

    public String getCfgValue() {
        return cfgValue;
    }

    public void setCfgValue(String cfgValue) {
        this.cfgValue = cfgValue;
    }
}
