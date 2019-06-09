package com.wechat.mgr.group.mapper;

import com.wechat.mgr.group.model.UserGroup;
import com.wechat.mgr.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGroupMapper {
    int insert(UserGroup record);

    int insertSelective(UserGroup record);

    List<User> selectUserByCode(String groupcode);

    int selectCountByCode(String groupcode);
}