package com.alibaba.wx.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.wx.service.IWxApiService;
import com.alibaba.wx.utils.HttpClientUtil;
import com.alibaba.wx.wxSdk.enums.WxQrType;
import org.springframework.stereotype.Service;

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
    /**
     * 获取管理token
     *
     * @return
     *
     * @throws Exception
     */
    public String getAccessToken(String appId, String appSecret) throws Exception {
        String result = null;
        String address = CGI_URL + "token";

        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("grant_type", "client_credential");
        paramsMap.put("appid", appId);
        paramsMap.put("secret", appSecret);

        String resp = HttpClientUtil.getInstance().sendHttpGet(address, paramsMap);
        System.out.println("resp: " + resp);
        result = JSON.toJSONString(resp);
        System.out.println("result: " + result);
        result = URLDecoder.decode(result, "UTF-8");

        return result;
    }

    /**
     * 获取JS JDK ticket值
     *
     * @param token
     *
     * @return
     *
     * @throws Exception
     */
    public String getJSTicket(String token) throws Exception {
        return null;
    }

    /**
     * 获取微信服务器IP地址
     *
     * @param token
     *
     * @return
     *
     * @throws Exception
     */
    public String getCallBackIP(String token) throws Exception {
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
    public String createMenu(String token, JSONObject buttons) throws Exception {
        return null;
    }

    /**
     * 查询菜单
     *
     * @param token
     *
     * @return
     *
     * @throws Exception
     */
    public String getMenu(String token) throws Exception {
        return null;
    }

    /**
     * 删除菜单
     *
     * @param token
     *
     * @return
     *
     * @throws Exception
     */
    public String deleteMenu(String token) throws Exception {
        return null;
    }

    /**
     * oauth 获取登录token
     *
     * @param code
     * @param state
     *
     * @return
     *
     * @throws Exception
     */
    public String GetAccessToken(String code, String state) throws Exception {
        return null;
    }

    /**
     * oauth 刷新登录token
     *
     * @param token
     *
     * @return
     *
     * @throws Exception
     */
    public String RefreshAccessToken(String token) throws Exception {
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
     * @throws Exception
     */
    public String getUserInfo(String token, String openId) throws Exception {
        return null;
    }

    /**
     * 管理员获取用户信息
     *
     * @param token
     * @param openId
     *
     * @return
     *
     * @throws Exception
     */
    public String getUser(String token, String openId) throws Exception {
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
     *
     * @throws Exception
     */
    public String createQRCode(String token, WxQrType type, long seconds, long sceneId, String sceneStr) throws Exception {
        return null;
    }

    /**
     * 长链接转短链接
     *
     * @param token
     * @param url
     *
     * @return
     *
     * @throws Exception
     */
    public String shortUrl(String token, String url) throws Exception {
        return null;
    }

    /**
     * 设置账号所属行业
     *
     * @param token
     * @param industry
     *
     * @return
     *
     * @throws Exception
     */
    public String setIndustry(String token, JSONObject industry) throws Exception {
        return null;
    }

    /**
     * 获取消息模板
     *
     * @param token
     * @param templateId
     *
     * @return
     *
     * @throws Exception
     */
    public String addTemplate(String token, String templateId) throws Exception {
        return null;
    }

    /**
     * 发送模板信息
     *
     * @param token
     * @param message
     *
     * @return
     *
     * @throws Exception
     */
    public String sendTemplate(String token, JSONObject message) throws Exception {
        return null;
    }
}
