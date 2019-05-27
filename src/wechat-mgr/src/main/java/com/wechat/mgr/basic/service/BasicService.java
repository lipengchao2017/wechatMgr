package com.wechat.mgr.basic.service;

import com.wechat.mgr.user.model.User;

public interface BasicService<T> {

    int deleteByPrimaryKey(String id);

    int insert(T record);

    int insertSelective(T record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

}
