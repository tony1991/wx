package com.alibaba.wx.wxSdk;

import com.alibaba.wx.wxSdk.domain.WxReqMsg;
import com.alibaba.wx.wxSdk.domain.WxRespMsg;
import com.alibaba.wx.wxSdk.domain.WxTextRespMsg;
import com.alibaba.wx.wxSdk.enums.WxMsgType;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;

/**
 * @Desc:
 * @Author: tony
 * @Date: Created in 17/6/23 上午9:13  
 */
public class WxUtil {
    public static final Logger logger = LoggerFactory.getLogger(WxUtil.class);
    public static final String token = "weixin";//此处需要跟公众号后台保持一致

    /**
     * token验证
     * @param request
     * @return
     * @throws Exception
     */
    public static String verifyUrl(HttpServletRequest request) throws Exception{
        boolean result = false;
        String echostr = request.getParameter("echostr");
        logger.info("echostr："+echostr);
        result = checkSignature(request);
        if(result)
            return echostr;
        else
            return null;
    }

    /**
     * 校验签名
     * @param request
     * @return
     */
    private static boolean checkSignature(HttpServletRequest request)
            throws Exception{
        boolean result = false;

        if (token == null || "".equals(token.trim())) {
            return false;
        }
        logger.info("token："+token);

        String signature = request.getParameter("signature");
        if (signature == null || "".equals(signature.trim())) {
            return false;
        }
        logger.info("signature："+signature);

        String timestamp = request.getParameter("timestamp");
        if (timestamp == null || "".equals(timestamp.trim())) {
            return false;
        }
        logger.info("timestamp："+timestamp);

        String nonce = request.getParameter("nonce");
        if (nonce == null || "".equals(nonce.trim())) {
            return false;
        }
        logger.info("nonce："+nonce);

        String tmpSignature = SHA1.getSHA1(token, timestamp, nonce);
        logger.info("tmpSignature:"+tmpSignature);

        if (tmpSignature.equals(signature)) {
            result = true;
        }
        return result;
    }

    public static String handXML(String xml, HttpServletRequest request) {
        String result = "";

        WxRespMsg response = handleXMLMessage(xml);
        if (null != response) {
            result = response.toString();
        }

        return result;
    }


    private static WxRespMsg handleXMLMessage(String xml) {
        String reqPkgPath = "com.alibaba.wx.wxSdk.domain.WxReqMsg";
        WxReqMsg reqMsg = parseXML(xml,reqPkgPath);

        WxRespMsg result = null;
        if (WxMsgType.EVENT.toString().equals(reqMsg.getMsgType())) {
            String event = reqMsg.getEvent();
            if ("unsubscribe".equals(event)) {
                // TODO: 记录取消关注事件

            } else if ("subscribe".equals(event)) {
                // TODO: 获取二维码信息，绑定用户账号

            } else if ("CLICK".equals(event)) {
                // TODO: 不同的菜单点击事件记录

            } else if ("SCAN".equals(event)) {
                // TODO: 获取二维码信息，绑定用户账号
            }

        }else {
            //默认返回文本事件
            String content = "您的消息我们已收到!";
            result = new WxTextRespMsg(reqMsg.getFromUserName(),
                    reqMsg.getToUserName(),
                    WxMsgType.Text.toString(),content);
        }

        return result;
    }

    /**
     * xml转java类
     * @param xml
     * @param classPkg 要转成的java类所在包的路径（包含类名）
     * @return
     */
    public static <T> T parseXML(String xml,String classPkg) {
        T result = null;

        try {
            if (xml == null || xml.length() <= 0)
                return null;
            // 将字符串转化为XML文档对象
            Document document = DocumentHelper.parseText(xml);
            // 获得文档的根节点
            Element root = document.getRootElement();
            // 遍历根节点下所有子节点
            Iterator<?> iter = root.elementIterator();
            // 遍历所有结点，利用反射机制，调用set方法，获取该实体的元类型
            Class<?> c = Class.forName(classPkg);
            // 创建这个实体的对象
            result = (T) c.newInstance();

            while (iter.hasNext()) {
                Element ele = (Element) iter.next();
                // 获取set方法中的参数字段（实体类的属性）
                Field field = c.getDeclaredField(ele.getName());
                // 获取set方法，field.getType())获取它的参数数据类型
                Method method = c.getDeclaredMethod("set" + ele.getName(),
                        field.getType());
                // 调用set方法
                method.invoke(result, ele.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}