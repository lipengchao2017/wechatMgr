package com.wechat.mgr.group.mapper;

import com.wechat.mgr.group.model.UserGroup;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroupMapper {
    int insert(UserGroup record);

    int insertSelective(UserGroup record);
}