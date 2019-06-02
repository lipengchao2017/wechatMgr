package com.wechat.mgr.user.service.impl;

import com.wechat.mgr.role.model.Role;
import com.wechat.mgr.user.mapper.UserMapper;
import com.wechat.mgr.user.model.User;
import com.wechat.mgr.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public User selectByUsercode(String usercode) {
        return userMapper.selectByUsercode(usercode);
    }

    @Override
    public int selectAllCount() {
        return userMapper.selectAllCount();
    }

    @Override
    public List<Role> selectAllWithPage(int i, int limit) {
        Map<String,Object> map = new HashMap<>();
        map.put("pstart",i);
        map.put("psize",limit);
        return userMapper.selectAllWithPage(map);
    }

    @Override
    public int deleteByUsercodes(List<String> codeStrs) {
        return userMapper.deleteByUsercodes(codeStrs);
    }
}
