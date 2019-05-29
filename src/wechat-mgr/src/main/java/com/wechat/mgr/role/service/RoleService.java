package com.wechat.mgr.role.service;

import com.wechat.mgr.basic.service.BasicService;
import com.wechat.mgr.role.model.Role;

import java.util.List;
import java.util.Map;

public interface RoleService extends BasicService<Role> {
    List<Role> selectAllWithPage(int start,int size);
}
