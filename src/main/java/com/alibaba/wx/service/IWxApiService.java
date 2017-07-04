package com.alibaba.wx.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.wx.wxSdk.enums.WxQrType;

/**
 * @Desc:微信API接口服务类
 * @Author: tony
 * @Date: Created in 17/6/27 下午11:02  
 */
public interface IWxApiService {
    /**
     * 获取管理token
     *
     * @return
     * @throws Exception
     */
    public String getAccessToken(String appId, String appSecret);

    /**
     * 获取JS JDK ticket值
     *
     * @param token
     * @return
     * @
     */
    public String getJSTicket(String token) ;

    /**
     * 获取微信服务器IP地址
     *
     * @return
     * @
     */
    public String getCallBackIP(String token) ;

    /**
     * 创建菜单
     *
     * @param token
     * @param buttons
     * @return
     * @
     */
    public String createMenu(String token, JSONObject buttons);

    /**
     * 查询菜单
     *
     * @param token
     * @return
     * @throws Exception
     */
    public String getMenu(String token);

    /**
     * 删除菜单
     *
     * @param token
     * @return
     * @throws Exception
     */
    public String deleteMenu(String token);

    /**
     * oauth 获取登录token
     *
     * @param code
     * @return
     * @throws Exception
     */
    public String GetAccessToken(String code, String state);

    /**
     * oauth 刷新登录token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public String RefreshAccessToken(String token);

    /**
     * oauth 获取用户信息
     *
     * @param token
     * @return
     * @throws Exception
     */
    public String getUserInfo(String token, String openId);

    /**
     * 管理员获取用户信息
     *
     * @param token
     * @param openId
     * @return
     * @throws Exception
     */
    public String getUser(String token, String openId);

    /**
     * 生成二维码
     * @param token
     * @param type
     * @param seconds
     * @param sceneId
     * @param sceneStr
     * @return
     * @throws Exception
     */
    public String createQRCode(String token, WxQrType type, long seconds,
                               long sceneId, String sceneStr);

    /**
     * 长链接转短链接
     *
     * @param token
     * @param url
     * @return
     * @throws Exception
     */
    public String shortUrl(String token, String url);

    /**
     * 设置账号所属行业
     *
     * @param token
     * @param industry
     * @return
     * @throws Exception
     */
    public String setIndustry(String token, JSONObject industry)
           ;

    /**
     * 获取消息模板
     *
     * @param token
     * @param templateId
     * @return
     * @throws Exception
     */
    public String addTemplate(String token, String templateId);

    /**
     * 发送模板信息
     *
     * @param token
     * @param message
     * @return
     * @throws Exception
     */
    public String sendTemplate(String token, JSONObject message);
}
