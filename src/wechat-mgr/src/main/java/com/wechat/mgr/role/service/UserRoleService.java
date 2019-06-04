package com.wechat.mgr.role.service;

import com.wechat.mgr.role.model.UserRole;

public interface UserRoleService {

    int insert(UserRole record);

    int insertSelective(UserRole record);
}
