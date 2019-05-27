package com.wechat.mgr.user.model;

import com.wechat.mgr.basic.model.BasicModel;

/**
 * 用户实体
 */
public class User extends BasicModel {
    private String userid;

    private String usercode;

    private String username;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

}