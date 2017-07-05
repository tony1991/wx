package com.alibaba.wx.wxSdk;

/**
 * @Desc:
 * @Author: tony
 * @Date: Created in 17/7/5 下午10:40  
 */
public class WxException extends Exception{
    public WxException(String msg) {
        super(msg);
    }

    public WxException(Exception e) {
        super(e);
    }

    public WxException(String msg, Exception e) {
        super(msg, e);
    }
}
