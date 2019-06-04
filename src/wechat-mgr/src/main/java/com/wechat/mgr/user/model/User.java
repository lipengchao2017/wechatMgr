package com.wechat.mgr.user.model;

import com.wechat.mgr.basic.model.BasicModel;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户实体
 */
public class User extends BasicModel {
    private String userid;

    private String usercode;

    private String username;

    //用户所有角色值，用于shiro做角色权限的判断
    private Set<String> roles = new HashSet<>();

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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}