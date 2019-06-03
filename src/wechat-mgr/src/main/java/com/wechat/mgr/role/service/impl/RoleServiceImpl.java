package com.wechat.mgr.role.service.impl;

import com.wechat.mgr.role.mapper.RoleMapper;
import com.wechat.mgr.role.model.Role;
import com.wechat.mgr.role.service.RoleService;
import com.wechat.mgr.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    @Override
    public int insertSelective(Role record) {
        return roleMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(String id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }


    @Override
    public List<Role> selectAllWithPage(int start, int size) {
        Map<String,Object> map = new HashMap<>();
        map.put("pstart",start);
        map.put("psize",size);
        return roleMapper.selectAllWithPage(map);
    }

    @Override
    public int selectAllCount() {
        return roleMapper.selectAllCount();
    }

    @Override
    public int deleteByRolecodes(List<String> sts) {
        return roleMapper.deleteByRolecodes(sts);
    }

    @Override
    public int selectIsExistByCode(String rolecode) {
        return roleMapper.selectIsExistByCode(rolecode);
    }
}
