package com.wechat.mgr.role.mapper;

import com.wechat.mgr.role.model.UserRole;
import com.wechat.mgr.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);

    List<User> selectUserByCode(String rolecode);

    int selectCountByCode(String rolecode);
}