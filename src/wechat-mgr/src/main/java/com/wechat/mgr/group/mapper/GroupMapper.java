package com.wechat.mgr.group.mapper;

import com.wechat.mgr.basic.mapper.BasicMapper;
import com.wechat.mgr.group.model.Group;
import com.wechat.mgr.role.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GroupMapper extends BasicMapper<Group> {

    int selectAllCount();

    List<Role> selectAllWithPage(Map<String, Object> map);

    int deleteByGroupcodes(List<String> codeStrs);
}