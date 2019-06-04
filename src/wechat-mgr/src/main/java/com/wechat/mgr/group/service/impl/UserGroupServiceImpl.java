package com.wechat.mgr.group.service.impl;

import com.wechat.mgr.group.mapper.UserGroupMapper;
import com.wechat.mgr.group.model.UserGroup;
import com.wechat.mgr.group.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userGroupService")
public class UserGroupServiceImpl implements UserGroupService {

    @Autowired
    private UserGroupMapper userGroupMapper;

    @Override
    public int insert(UserGroup record) {
        return userGroupMapper.insert(record);
    }

    @Override
    public int insertSelective(UserGroup record) {
        return userGroupMapper.insertSelective(record);
    }
}
