package com.wechat.mgr.role.service;

import com.wechat.mgr.role.model.UserRole;
import com.wechat.mgr.user.model.User;

import java.util.List;

public interface UserRoleService {

    int insert(UserRole record);

    int insertSelective(UserRole record);

    List<User> selectUserByCode(String rolecode);

    int selectCountByCode(String rolecode);
}
