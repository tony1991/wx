package com.alibaba.wx.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Desc:
 * @Author: tony
 * @Date: Created in 17/7/6 上午10:06  
 */
@Component
public class ConfigProperties {
    @Value("${wx.appId}")
    public String wxAppId;

    @Value("${wx.appSecret}")
    public String wxAppSecret;

    public String getWxAppId() {
        return wxAppId;
    }

    public void setWxAppId(String wxAppId) {
        this.wxAppId = wxAppId;
    }

    public String getWxAppSecret() {
        return wxAppSecret;
    }

    public void setWxAppSecret(String wxAppSecret) {
        this.wxAppSecret = wxAppSecret;
    }
}
