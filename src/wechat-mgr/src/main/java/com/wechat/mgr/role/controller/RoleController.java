package com.wechat.mgr.role.controller;

import com.alibaba.fastjson.JSONArray;
import com.wechat.mgr.role.model.Role;
import com.wechat.mgr.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 角色控制器
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 角色台账页面
     * @return
     */
    @RequestMapping("/main")
    private String toRoleMain(){
        return "/role/main";
    }

    /**
     * 显示台账数据
     * @return
     */
    @GetMapping(value = "/show")
    @ResponseBody
    private Map<String,Object> showDatas(@RequestParam("page") int page,@RequestParam("limit") int limit){
        List<Role> roles = roleService.selectAllWithPage(page, limit);
        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("code",0);
        returnMap.put("msg","");
        returnMap.put("count",10);
        returnMap.put("data",roles);
        return returnMap;
    }





}
