package com.alibaba.wx.controller;

import com.alibaba.wx.constants.ConfigProperties;
import com.alibaba.wx.model.Config;
import com.alibaba.wx.service.IWxApiService;
import com.alibaba.wx.service.WxService;
import com.alibaba.wx.wxSdk.WxException;
import com.alibaba.wx.wxSdk.domain.OauthToken;
import com.alibaba.wx.wxSdk.domain.OauthUser;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Desc:
 * @Author: tony
 * @Date: Created in 17/6/28 下午9:43  
 */
@Controller
@RequestMapping("test")
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private IWxApiService wxApiServiceImpl;

    @Autowired
    private WxService wxService;

    @Resource
    private ConfigProperties cfgProp;

    /**
     * 获取token并入库
     */
    @RequestMapping(value = "token", method = RequestMethod.GET)
    public String getAccessToken() {
        //测试token获取
        logger.info("");
        String accessToken = null;
        try {
            accessToken = wxApiServiceImpl.getAccessToken(
                    cfgProp.getWxAppId(), cfgProp.getWxAppSecret());
        } catch (WxException e) {
            logger.info(e.getMessage());
            return "error";
        }
        logger.info("accessToken:" + accessToken);
        //入库
        Config config = new Config();
        config.setCfgKey("accessToken");
        config.setCfgValue(accessToken);
        wxService.updateAccessToken(config);
        return "index";
    }

    /**
     * 更新token
     */
    @RequestMapping(value = "refreshToken", method = RequestMethod.GET)
    public String refreshToken() {
        //测试token获取
        String accessToken = null;
        try {
            accessToken = wxApiServiceImpl.getAccessToken(
                    cfgProp.getWxAppId(), cfgProp.getWxAppSecret());
        } catch (WxException e) {
            logger.info(e.getMessage());
            return "error";
        }
        logger.info("accessToken:" + accessToken);
        //入库
        Config config = new Config();
        config.setCfgKey("accessToken");
        config.setCfgValue(accessToken);
        wxService.updateAccessToken(config);
        return "index";
    }

    /**
     * 获取网页授权token
     */
    @RequestMapping(value = "oauthToken", method = RequestMethod.GET)
    public String getOauthToken() {
        //测试token获取
        logger.info("");
        String accessToken = null;
        try {
            accessToken = wxApiServiceImpl.getAccessToken(
                    cfgProp.getWxAppId(), cfgProp.getWxAppSecret());
        } catch (WxException e) {
            logger.info(e.getMessage());
            return "error";
        }
        logger.info("accessToken:" + accessToken);
        return "index";
    }

    /**
     * 获取网页用户信息
     */
    @RequestMapping(value = "userInfo", method = RequestMethod.GET)
    public String getUserInfo(HttpServletRequest request) {
        logger.info("获取网页用户信息");
        //1.先获取code
        String code = request.getParameter("code");
        logger.info("code:" + code);
        //如果code为空，则无法获取用户信息
        if (StringUtils.isBlank(code)) {
            return "error";
        }
        //2.先获取access_token和openId
        OauthToken oauthToken = null;
        try {
            oauthToken = wxApiServiceImpl.getOauthToken(code,
                    cfgProp.getWxAppId(), cfgProp.getWxAppSecret());
            logger.info("accessToken:" + oauthToken.getAccess_token());
            //3.再拉取用户信息
            OauthUser oauthUser = wxApiServiceImpl.getUserInfo(oauthToken.getAccess_token(),
                    oauthToken.getOpenid());
            logger.info("oauthUser nickname:" + oauthUser.getNickname());
        } catch (WxException e) {
        logger.info(e.getMessage());
            return "error";
        }
        return "index";
    }
}
