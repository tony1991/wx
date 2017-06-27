package com.alibaba.wx.wxSdk.enums;

/**
 * @Desc:
 * @Author: tony
 * @Date: Created in 17/6/27 下午11:05  
 */
public enum WxQrType {
    QR_SCENE(0, "QR_SCENE"),
    QR_LIMIT_SCENE(1, "QR_LIMIT_SCENE"),
    QR_LIMIT_STR_SCENE(2, "QR_LIMIT_STR_SCENE");

    private int index;
    private String description;

    private WxQrType(int index, String description) {
        this.index = index;
        this.description = description;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
