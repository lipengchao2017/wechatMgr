package com.wechat.mgr.role.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.wechat.mgr.role.model.Role;
import com.wechat.mgr.role.service.RoleService;
import com.wechat.mgr.role.service.UserRoleService;
import com.wechat.mgr.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * 获取角色树数据
     * @return
     */
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

    @RequestMapping("/toShowInput")
    public String toShowInput(){
        return "/userrole/input";
    }

    @GetMapping("/selectUserByRole")
    @ResponseBody
    public List<User> selectUserByRole(@RequestParam("rolecode") String rolecode){
        //通过usercode获取
        List<User> users = userRoleService.selectUserByCode(rolecode);
        return null;
    }

    @RequestMapping("/saveRel")
    @ResponseBody
    public String saveRel(@RequestParam("rolecode") String rolecode,@RequestParam("username") String username){

        System.out.println(rolecode);
        System.out.println(username);


        return null;
    }

}
