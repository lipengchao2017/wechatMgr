package com.wechat.mgr.user.service;

import com.wechat.mgr.basic.service.BasicService;
import com.wechat.mgr.role.model.Role;
import com.wechat.mgr.user.model.User;

import java.util.List;

public interface UserService extends BasicService<User> {
    User selectByUsercode(String usercode);

    int selectAllCount();

    List<Role> selectAllWithPage(int i, int limit);

    int deleteByUsercodes(List<String> codeStrs);
}
