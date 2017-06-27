package com.alibaba.wx.controller;

/**
 * @Desc:
 * @Author: tony
 * @Date: Created in 17/6/19 下午8:51  
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.wx.wxSdk.AesException;
import com.alibaba.wx.wxSdk.WxUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping("wx")
public class WxController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(BaseController.class);
    /**
     * get请求表示接入微信，验证url
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "process", method = RequestMethod.GET)
    public void process(HttpServletRequest request,
                        HttpServletResponse response) throws IOException {
        logger.info("收到微信get请求...");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        //对请求进行校验
        try {
            String realEchoStr = WxUtil.verifyUrl(request);
            logger.info("realEchoStr："+realEchoStr);
            if (realEchoStr != null) {
                out.print(realEchoStr);
            }
        } catch (AesException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.close();
    }

    /**
     * post请求表示接收微信后台发送的信息
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "process", method = RequestMethod.POST)
    public void doProcess(HttpServletRequest request,
                        HttpServletResponse response) throws IOException {
        logger.info("收到微信post请求...");
        request.setCharacterEncoding("UTF-8");
        OutputStream os = response.getOutputStream();
        String wxReqJson = JSON.toJSONString(request
                .getParameterMap());
        logger.info("请求数据: " + wxReqJson);

        // 接收到微信端发送过来的xml数据
        StringBuffer sb = new StringBuffer();
        InputStream is = request.getInputStream();
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String s = "";
        while ((s = br.readLine()) != null) {
            sb.append(s);
        }
        // 关闭输入流
        br.close();
        isr.close();
        is.close();

        // 处理xml消息数据
        String xml = sb.toString();
        logger.info("message body: " + xml);
        if (!StringUtils.isBlank(xml)) {
            String result = WxUtil.handXML(xml, request);
            logger.info("response: " + result);

            // 输出返回结果
            os.write(result.getBytes("UTF-8"));
            os.flush();
        }
        os.close();
    }
}