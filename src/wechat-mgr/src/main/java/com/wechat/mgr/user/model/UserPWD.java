package com.wechat.mgr.user.model;

import com.wechat.mgr.basic.model.BasicModel;

import java.util.Date;

/**
 * 用户密码
 */
public class UserPWD extends BasicModel {
    private String id;

    private String usercode;

    private String userpwd;

    private Integer isinitpwd;

    private Integer iseffective;

    private Integer locktype;

    private Integer errorcount;

    private Date locktime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd == null ? null : userpwd.trim();
    }

    public Integer getIsinitpwd() {
        return isinitpwd;
    }

    public void setIsinitpwd(Integer isinitpwd) {
        this.isinitpwd = isinitpwd;
    }

    public Integer getIseffective() {
        return iseffective;
    }

    public void setIseffective(Integer iseffective) {
        this.iseffective = iseffective;
    }

    public Integer getLocktype() {
        return locktype;
    }

    public void setLocktype(Integer locktype) {
        this.locktype = locktype;
    }

    public Integer getErrorcount() {
        return errorcount;
    }

    public void setErrorcount(Integer errorcount) {
        this.errorcount = errorcount;
    }

    public Date getLocktime() {
        return locktime;
    }

    public void setLocktime(Date locktime) {
        this.locktime = locktime;
    }
}