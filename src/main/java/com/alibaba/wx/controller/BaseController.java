package com.alibaba.wx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Desc:
 * @Author: tony
 * @Date: Created in 17/6/19 下午8:52  
 */
public abstract class BaseController {

    /**
     * 设置会话信息
     *
     * @param request
     * @param name
     * @param value
     */
    public void setSession(HttpServletRequest request,String name, String value) {
        HttpSession session = request.getSession();
        session.setAttribute(name, value);
    }

    /**
     * 清空用户会话信息
     *
     * @param request
     */
    public void clearSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        //FIXME
        session.removeAttribute("");
    }

}
