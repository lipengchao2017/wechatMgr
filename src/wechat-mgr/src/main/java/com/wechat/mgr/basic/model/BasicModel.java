package com.wechat.mgr.basic.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Basic父类
 */
public class BasicModel implements Serializable {

    private String creator;

    private String creatorid;

    private String updator;

    private String updatorid;

    private Date createtime;

    private Date updatetime;

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(String creatorid) {
        this.creatorid = creatorid;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }

    public String getUpdatorid() {
        return updatorid;
    }

    public void setUpdatorid(String updatorid) {
        this.updatorid = updatorid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}
