package com.alibaba.wx.service;

import com.alibaba.wx.dao.WxConfigMapper;
import com.alibaba.wx.model.Config;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @Desc:
 * @Author: tony
 * @Date: Created in 17/7/4 下午3:41  
 */

@Service
public class WxService {

    @Resource
    private WxConfigMapper wxConfigMapper;

    public void updateAccessToken(Config cfg){
        wxConfigMapper.updateCfg(cfg);
    }
}
