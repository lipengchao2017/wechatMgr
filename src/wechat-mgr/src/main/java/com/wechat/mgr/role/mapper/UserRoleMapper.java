package com.wechat.mgr.role.mapper;

import com.wechat.mgr.role.model.UserRole;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
}