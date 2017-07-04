package com.alibaba.wx.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.wx.service.IWxApiService;
import com.alibaba.wx.utils.HttpClientUtil;
import com.alibaba.wx.wxSdk.enums.WxQrType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @Desc:
 * @Author: tony
 * @Date: Created in 17/6/27 下午11:08  
 */
@Service
public class WxApiServiceImpl implements IWxApiService {
    public static String OAUTH_URL = "https://api.weixin.qq.com/sns/";
    public static String CGI_URL = "https://api.weixin.qq.com/cgi-bin/";
    private final Logger logger = LoggerFactory.getLogger(WxApiServiceImpl.class);

    /**
     * 获取管理token
     *
     * @return
     */
    public String getAccessToken(String appId, String appSecret) {
        String result;
        String address = CGI_URL + "token";

        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("grant_type", "client_credential");
        paramsMap.put("appid", appId);
        paramsMap.put("secret", appSecret);

        String resp = HttpClientUtil.getInstance().sendHttpGet(address, paramsMap);
        result = JSON.toJSONString(resp);
        logger.info("result: " + result);

        try {
            result = URLDecoder.decode(result, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 获取JS JDK ticket值
     *
     * @param token
     *
     * @return
     */
    public String getJSTicket(String token) {
        return null;
    }

    /**
     * 获取微信服务器IP地址
     *
     * @param token
     *
     * @return
     */
    public String getCallBackIP(String token) {
        return null;
    }

    /**
     * 创建菜单
     *
     * @param token
     * @param buttons
     *
     * @return
     *
     * @throws Exception
     */
    public String createMenu(String token, JSONObject buttons) {
        return null;
    }

    /**
     * 查询菜单
     *
     * @param token
     *
     * @return
     */
    public String getMenu(String token) {
        return null;
    }

    /**
     * 删除菜单
     *
     * @param token
     *
     * @return
     */
    public String deleteMenu(String token) {
        return null;
    }

    /**
     * oauth 获取登录token
     *
     * @param code
     * @param state
     *
     * @return
     */
    public String GetAccessToken(String code, String state) {
        return null;
    }

    /**
     * oauth 刷新登录token
     *
     * @param token
     *
     * @return
     */
    public String RefreshAccessToken(String token) {
        return null;
    }

    /**
     * oauth 获取用户信息
     *
     * @param token
     * @param openId
     *
     * @return
     *
     */
    public String getUserInfo(String token, String openId) {
        return null;
    }

    /**
     * 管理员获取用户信息
     *
     * @param token
     * @param openId
     *
     * @return
     */
    public String getUser(String token, String openId) {
        return null;
    }

    /**
     * 生成二维码
     *
     * @param token
     * @param type
     * @param seconds
     * @param sceneId
     * @param sceneStr
     *
     * @return
     */
    public String createQRCode(String token, WxQrType type,
                               long seconds, long sceneId, String sceneStr) {
        return null;
    }

    /**
     * 长链接转短链接
     *
     * @param token
     * @param url
     *
     * @return
     */
    public String shortUrl(String token, String url) {
        return null;
    }

    /**
     * 设置账号所属行业
     *
     * @param token
     * @param industry
     *
     * @return
     */
    public String setIndustry(String token, JSONObject industry) {
        return null;
    }

    /**
     * 获取消息模板
     *
     * @param token
     * @param templateId
     *
     * @return
     */
    public String addTemplate(String token, String templateId) {
        return null;
    }

    /**
     * 发送模板信息
     *
     * @param token
     * @param message
     *
     * @return
     */
    public String sendTemplate(String token, JSONObject message) {
        return null;
    }
}
