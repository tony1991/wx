package com.alibaba.wx.wxSdk.domain;

import com.alibaba.wx.wxSdk.enums.WxMsgType;

/**
 * @Desc:应答消息子类
 * 注：必须重写父类的toString方法，不然无法转成微信识别的字符串
 * @Author: tony
 * @Date: Created in 17/6/23 下午8:51  
 */
public class WxTextRespMsg extends WxRespMsg{
    /**
     * 消息类型:文本消息
     */
    private String msgType = WxMsgType.Text.toString();
    /**
     * 文本消息
     */
    private String content;

    public WxTextRespMsg(String toUserName, String fromUserName) {
        super(toUserName, fromUserName);
    }

    public WxTextRespMsg(String toUserName, String fromUserName,String msgType, String content) {
        super(toUserName, fromUserName);
        this.msgType = msgType;
        this.content = content;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("<xml>");
        // 基本信息
        sb.append("<ToUserName><![CDATA[");
        sb.append(toUserName);
        sb.append("]]></ToUserName><FromUserName><![CDATA[");
        sb.append(fromUserName);
        sb.append("]]></FromUserName><CreateTime>");
        sb.append(createTime);
        sb.append("</CreateTime>");
        sb.append("<MsgType><![CDATA[");
        sb.append(msgType);
        sb.append("]]></MsgType>");
        sb.append("<Content><![CDATA[");
        sb.append(content);
        sb.append("]]></Content>");
        // 最后关闭
        sb.append("</xml>");

        return sb.toString();
    }
}
