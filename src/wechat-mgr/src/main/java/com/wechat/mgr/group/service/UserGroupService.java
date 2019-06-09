package com.wechat.mgr.group.service;

import com.wechat.mgr.group.model.UserGroup;
import com.wechat.mgr.user.model.User;

import java.util.List;

public interface UserGroupService {

    int insert(UserGroup record);

    int insertSelective(UserGroup record);

    List<User> selectUserByCode(String groupcode);

    int selectCountByCode(String groupcode);
}
