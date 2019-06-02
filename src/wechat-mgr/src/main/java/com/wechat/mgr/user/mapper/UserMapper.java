package com.wechat.mgr.user.mapper;

import com.wechat.mgr.basic.mapper.BasicMapper;
import com.wechat.mgr.user.model.User;
import org.springframework.stereotype.Repository;

/**
 * 接口继承接口 用户接口
 */
@Repository
public interface UserMapper extends BasicMapper<User> {

    User selectByUsercode(String usercode);
}