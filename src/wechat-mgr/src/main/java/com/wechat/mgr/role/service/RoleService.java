package com.wechat.mgr.role.service;

import com.wechat.mgr.basic.service.BasicService;
import com.wechat.mgr.role.model.Role;

import java.util.List;

public interface RoleService extends BasicService<Role> {
    List<Role> selectAllWithPage(int start,int size);

    int selectAllCount();

    int deleteByRolecodes(List<String> sts);

    int selectIsExistByCode(String rolecode);

    List<Role> selectAllData();
}
