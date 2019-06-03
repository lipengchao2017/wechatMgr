package com.wechat.mgr.group.service.impl;

import com.wechat.mgr.group.mapper.GroupMapper;
import com.wechat.mgr.group.model.Group;
import com.wechat.mgr.group.service.GroupService;
import com.wechat.mgr.role.model.Role;
import com.wechat.mgr.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("groupService")
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupMapper groupMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return groupMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Group record) {
        return groupMapper.insert(record);
    }

    @Override
    public int insertSelective(Group record) {
        return groupMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(String id) {
        return groupMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Group record) {
        return groupMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Group record) {
        return groupMapper.updateByPrimaryKey(record);
    }

    @Override
    public int selectAllCount() {
        return groupMapper.selectAllCount();
    }

    @Override
    public List<Role> selectAllWithPage(int i, int limit) {
        Map<String,Object> map = new HashMap<>();
        map.put("pstart",i);
        map.put("psize",limit);
        return groupMapper.selectAllWithPage(map);
    }

    @Override
    public int deleteByGroupcodes(List<String> codeStrs) {
        return groupMapper.deleteByGroupcodes(codeStrs);
    }

    @Override
    public int selectIsExistByCode(String groupcode) {
        return groupMapper.selectIsExistByCode(groupcode);
    }
}
