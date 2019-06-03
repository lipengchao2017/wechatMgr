package com.wechat.mgr.user.service;

import com.wechat.mgr.basic.service.BasicService;
import com.wechat.mgr.user.model.UserPWD;

public interface UserPWDService extends BasicService<UserPWD> {
    String selectPwdByUserCode(String usercode);

    void updateEffByCode(String usercode);
}
