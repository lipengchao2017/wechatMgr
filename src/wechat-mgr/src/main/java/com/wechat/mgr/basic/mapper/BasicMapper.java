package com.wechat.mgr.basic.mapper;

import com.wechat.mgr.user.model.User;

public interface BasicMapper<T> {

    int deleteByPrimaryKey(String id);

    int insert(T record);

    int insertSelective(T record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

}
