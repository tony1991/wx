package com.alibaba.wx.controller;

import com.alibaba.wx.service.IWxApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    /**
     * get请求表示接入微信，验证url
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "token", method = RequestMethod.GET)
    public String process(Model model,HttpServletRequest request,
                        HttpServletResponse response) throws IOException {
        logger.info("进入首页");
        try {
            //FIXME 这里需要填上可配置的appId
            String appId = "";
            String appSecret = "";
            String accessToken = wxApiServiceImpl.getAccessToken(appId,appSecret);
            logger.info("accessToken:"+accessToken);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //测试token获取
        return "index";
    }
}
