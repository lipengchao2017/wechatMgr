package com.wechat.mgr.role.controller;

import com.wechat.mgr.role.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 角色人员控制器
 */
@Controller
@RequestMapping("/userrole")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    /**
     * 跳至角色人员页面
     * @return
     */
    @RequestMapping("/toMain")
    public String toMain(){

        return null;
    }




}
