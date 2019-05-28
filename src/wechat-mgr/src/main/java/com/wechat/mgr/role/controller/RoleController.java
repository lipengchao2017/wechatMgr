package com.wechat.mgr.role.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * 角色控制器
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @RequestMapping("/main")
    private String toRoleMain(){
        return "/role/main";
    }

}
