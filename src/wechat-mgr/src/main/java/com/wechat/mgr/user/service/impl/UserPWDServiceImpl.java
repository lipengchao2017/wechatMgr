package com.wechat.mgr.user.service.impl;

import com.wechat.mgr.user.mapper.UserPWDMapper;
import com.wechat.mgr.user.model.User;
import com.wechat.mgr.user.model.UserPWD;
import com.wechat.mgr.user.service.UserPWDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userPWDService")
public class UserPWDServiceImpl implements UserPWDService {

    @Autowired
    private UserPWDMapper userPWDMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return userPWDMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserPWD record) {
        return userPWDMapper.insert(record);
    }

    @Override
    public int insertSelective(UserPWD record) {
        return userPWDMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(String id) {
        return userPWDMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserPWD record) {
        return userPWDMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserPWD record) {
        return userPWDMapper.updateByPrimaryKey(record);
    }
}
