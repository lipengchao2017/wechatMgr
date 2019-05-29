package com.wechat.mgr.role.mapper;

import com.wechat.mgr.basic.mapper.BasicMapper;
import com.wechat.mgr.role.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RoleMapper extends BasicMapper<Role> {
    List<Role> selectAllWithPage(Map<String,Object> map);
}