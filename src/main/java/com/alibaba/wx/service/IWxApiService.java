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
    public String getAccessToken(String appId, String appSecret) throws Exception;

    /**
     * 获取JS JDK ticket值
     *
     * @param token
     * @return
     * @throws Exception
     */
    public String getJSTicket(String token) throws Exception;

    /**
     * 获取微信服务器IP地址
     *
     * @return
     * @throws Exception
     */
    public String getCallBackIP(String token) throws Exception;

    /**
     * 创建菜单
     *
     * @param token
     * @param buttons
     * @return
     * @throws Exception
     */
    public String createMenu(String token, JSONObject buttons) throws Exception;

    /**
     * 查询菜单
     *
     * @param token
     * @return
     * @throws Exception
     */
    public String getMenu(String token) throws Exception;

    /**
     * 删除菜单
     *
     * @param token
     * @return
     * @throws Exception
     */
    public String deleteMenu(String token) throws Exception;

    /**
     * oauth 获取登录token
     *
     * @param code
     * @return
     * @throws Exception
     */
    public String GetAccessToken(String code, String state) throws Exception;

    /**
     * oauth 刷新登录token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public String RefreshAccessToken(String token) throws Exception;

    /**
     * oauth 获取用户信息
     *
     * @param token
     * @return
     * @throws Exception
     */
    public String getUserInfo(String token, String openId) throws Exception;

    /**
     * 管理员获取用户信息
     *
     * @param token
     * @param openId
     * @return
     * @throws Exception
     */
    public String getUser(String token, String openId) throws Exception;

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
                               long sceneId, String sceneStr) throws Exception;

    /**
     * 长链接转短链接
     *
     * @param token
     * @param url
     * @return
     * @throws Exception
     */
    public String shortUrl(String token, String url) throws Exception;

    /**
     * 设置账号所属行业
     *
     * @param token
     * @param industry
     * @return
     * @throws Exception
     */
    public String setIndustry(String token, JSONObject industry)
            throws Exception;

    /**
     * 获取消息模板
     *
     * @param token
     * @param templateId
     * @return
     * @throws Exception
     */
    public String addTemplate(String token, String templateId) throws Exception;

    /**
     * 发送模板信息
     *
     * @param token
     * @param message
     * @return
     * @throws Exception
     */
    public String sendTemplate(String token, JSONObject message)
            throws Exception;
}
