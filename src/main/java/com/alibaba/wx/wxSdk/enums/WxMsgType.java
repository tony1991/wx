package com.alibaba.wx.wxSdk.enums;

/**
 * @Desc:消息类型枚举类
 * @Author: tony
 * @Date: Created in 17/6/23 下午8:33  
 */
public enum WxMsgType {
    Text("text"),
    Image("image"),
    Music("music"),
    Video("video"),
    Voice("voice"),
    Location("location"),
    NEWS("news"),
    EVENT("event"),
    Link("link"),
    CUSTOMER("transfer_customer_service");
    private String msgType = "";

    WxMsgType(String msgType) {
        this.msgType = msgType;
    }

    /**
     * @return the msgType
     */
    @Override
    public String toString() {
        return msgType;
    }
}
