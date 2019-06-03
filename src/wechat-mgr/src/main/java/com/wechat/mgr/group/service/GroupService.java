package com.wechat.mgr.group.service;

import com.wechat.mgr.basic.service.BasicService;
import com.wechat.mgr.group.model.Group;
import com.wechat.mgr.role.model.Role;

import java.util.List;

public interface GroupService extends BasicService<Group> {
    int selectAllCount();

    List<Role> selectAllWithPage(int i, int limit);

    int deleteByGroupcodes(List<String> codeStrs);

    int selectIsExistByCode(String groupcode);
}
