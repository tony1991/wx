package com.alibaba.wx.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.wx.service.IWxApiService;
import com.alibaba.wx.utils.HttpClientUtil;
import com.alibaba.wx.wxSdk.WxCode;
import com.alibaba.wx.wxSdk.WxException;
import com.alibaba.wx.wxSdk.domain.OauthToken;
import com.alibaba.wx.wxSdk.domain.OauthUser;
import com.alibaba.wx.wxSdk.enums.WxQrType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc:
 * @Author: tony
 * @Date: Created in 17/6/27 下午11:08  
 */
@Service
public class WxApiServiceImpl implements IWxApiService {
    public static String CGI_URL = "https://api.weixin.qq.com/cgi-bin/";
    public static String OAUTH_URL = "https://api.weixin.qq.com/sns/";
    private final Logger logger = LoggerFactory.getLogger(WxApiServiceImpl.class);

    /**
     * 获取管理token
     *
     * @return
     */
    public String getAccessToken(String appId, String appSecret) throws WxException {
        String result = "";
        String address = CGI_URL + "token";

        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("grant_type", "client_credential");
        paramsMap.put("appid", appId);
        paramsMap.put("secret", appSecret);

        String resp = HttpClientUtil.getInstance().sendHttpGet(address, paramsMap);
        JSONObject jsonObj = JSONObject.parseObject(resp);
        logger.info("jsonObj: " + jsonObj);
        Object errcode = jsonObj.get("errcode");
        if (errcode != null) {
            //返回异常信息
            throw new WxException(WxCode.getResultMsg(Integer.parseInt(errcode.toString())));
        }
        //判断是否登录成功，并判断过期时间
        Object token = jsonObj.get("access_token");
        //登录成功，设置accessToken和过期时间
        if (token != null) {
            result = token+"";
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
     * oauth 获取网页授权token
     *
     * @param code
     *
     * @return
     */
    public OauthToken getOauthToken(String code, String appId,
                                String appSecret) throws WxException{
        OauthToken oauthToken = new OauthToken();
        String address = OAUTH_URL + "oauth2/access_token";

        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("grant_type", "authorization_code");
        paramsMap.put("appid", appId);
        paramsMap.put("secret", appSecret);
        paramsMap.put("code", code);

        String resp = HttpClientUtil.getInstance().sendHttpPost(address, paramsMap);
        JSONObject jsonObj = JSONObject.parseObject(resp);
        logger.info("网页授权token jsonObj: " + jsonObj);
        Object errcode = jsonObj.get("errcode");
        if (errcode != null) {
            //返回异常信息
            throw new WxException(WxCode.getResultMsg(Integer.parseInt(errcode.toString())));
        }
        //将微信返回信息转化成对象
        oauthToken = JSONObject.toJavaObject(jsonObj,OauthToken.class);
        return oauthToken;
    }

    /**
     * oauth 刷新登录token
     *
     * @param token
     *
     * @return
     */
    public String refreshAccessToken(String token) {
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
    public OauthUser getUserInfo(String token, String openId) throws WxException{
        OauthUser oauthUser = new OauthUser();
        String address = OAUTH_URL + "userinfo";

        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("access_token", token);
        paramsMap.put("openid", openId);
        paramsMap.put("lang","zh_CN");

        String resp = HttpClientUtil.getInstance().sendHttpGet(address, paramsMap);
        JSONObject jsonObj = JSONObject.parseObject(resp);
        logger.info("网页授权用户信息jsonObj: " + jsonObj);
        Object errcode = jsonObj.get("errcode");
        if (errcode != null) {
            //返回异常信息
            throw new WxException(WxCode.getResultMsg(Integer.parseInt(errcode.toString())));
        }
        //将微信返回信息转化成对象
        oauthUser = JSONObject.toJavaObject(jsonObj,OauthUser.class);
        return oauthUser;
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
