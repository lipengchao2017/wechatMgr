package com.wechat.mgr.group.service;

import com.wechat.mgr.group.model.UserGroup;

public interface UserGroupService {

    int insert(UserGroup record);

    int insertSelective(UserGroup record);
}
