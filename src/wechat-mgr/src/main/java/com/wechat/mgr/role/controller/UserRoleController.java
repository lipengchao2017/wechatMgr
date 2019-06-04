package com.wechat.mgr.role.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.wechat.mgr.role.model.Role;
import com.wechat.mgr.role.service.RoleService;
import com.wechat.mgr.role.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色人员控制器
 */
@Controller
@RequestMapping("/userrole")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleService roleService;

    /**
     * 跳至角色人员页面
     * @return
     */
    @RequestMapping("/toMain")
    public String toMain(){
        return "/userrole/main";
    }

    @GetMapping("/getTree")
    @ResponseBody
    public List<Map<String,String>> getTree(){
        List<Role> roles = roleService.selectAllData();
        //拼装数据
        List<Map<String,String>> reRoles = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        for (Role role : roles){
            map = new HashMap<>();
            map.put("id",role.getRolecode());
            map.put("label",role.getRolename());
            reRoles.add(map);
        }
        return reRoles;
    }




}
