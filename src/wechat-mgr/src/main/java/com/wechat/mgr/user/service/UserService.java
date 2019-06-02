package com.wechat.mgr.user.service;

import com.wechat.mgr.basic.service.BasicService;
import com.wechat.mgr.user.model.User;

public interface UserService extends BasicService<User> {
    User selectByUsercode(String usercode);
}
