package com.alibaba.wx.wxSdk.domain;

/**
 * @Desc:公众号响应消息基类
 * @Author: tony
 * @Date: Created in 17/6/23 下午8:48  
 */
public abstract class WxRespMsg implements java.io.Serializable {
    /**
     * 接收方帐号（收到的OpenID）
     */
    public String toUserName;
    /**
     * 开发者微信号
     */
    public String fromUserName;
    /**
     * 消息创建时间 （整型）
     */
    public Long createTime;

    public WxRespMsg(String toUserName, String fromUserName) {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = System.currentTimeMillis();
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "";//默认返回空
    }
}
