package com.wechat.mgr.group.service.impl;

import com.wechat.mgr.group.mapper.UserGroupMapper;
import com.wechat.mgr.group.model.UserGroup;
import com.wechat.mgr.group.service.UserGroupService;
import com.wechat.mgr.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<User> selectUserByCode(String groupcode) {
        return userGroupMapper.selectUserByCode(groupcode);
    }

    @Override
    public int selectCountByCode(String groupcode) {
        return userGroupMapper.selectCountByCode(groupcode);
    }
}
