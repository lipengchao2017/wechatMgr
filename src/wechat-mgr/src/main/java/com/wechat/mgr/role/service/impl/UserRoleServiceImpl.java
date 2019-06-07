package com.wechat.mgr.role.service.impl;

import com.wechat.mgr.role.mapper.UserRoleMapper;
import com.wechat.mgr.role.model.UserRole;
import com.wechat.mgr.role.service.UserRoleService;
import com.wechat.mgr.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;


    @Override
    public int insert(UserRole record) {
        return userRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(UserRole record) {
        return userRoleMapper.insertSelective(record);
    }

    @Override
    public List<User> selectUserByCode(String rolecode) {
        return userRoleMapper.selectUserByCode(rolecode);
    }

    @Override
    public int selectCountByCode(String rolecode) {
        return userRoleMapper.selectCountByCode(rolecode);
    }
}
