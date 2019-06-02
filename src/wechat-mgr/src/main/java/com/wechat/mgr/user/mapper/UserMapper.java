package com.wechat.mgr.user.mapper;

import com.wechat.mgr.basic.mapper.BasicMapper;
import com.wechat.mgr.role.model.Role;
import com.wechat.mgr.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 接口继承接口 用户接口
 */
@Repository
public interface UserMapper extends BasicMapper<User> {

    User selectByUsercode(String usercode);

    int selectAllCount();

    List<Role> selectAllWithPage(Map<String, Object> map);

    int deleteByUsercodes(List<String> codeStrs);
}