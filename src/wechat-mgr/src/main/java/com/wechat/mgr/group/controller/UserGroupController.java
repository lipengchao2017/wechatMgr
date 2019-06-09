package com.wechat.mgr.group.controller;

import com.wechat.mgr.group.model.Group;
import com.wechat.mgr.group.service.GroupService;
import com.wechat.mgr.group.service.UserGroupService;
import com.wechat.mgr.role.model.Role;
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

@Controller
@RequestMapping("/usergroup")
public class UserGroupController {

    @Autowired
    private UserGroupService userGroupService;

    @Autowired
    private GroupService groupService;

    @RequestMapping("/toMain")
    public String toMain(){
        return "/usergroup/main";
    }

    @RequestMapping("/toShowInput")
    public String toShowInput(){
        return "/usergroup/input";
    }

    @GetMapping("/selectUserByGroup")
    @ResponseBody
    public Map<String,Object> selectUserByGroup(@RequestParam("groupcode") String groupcode){
        List<User> users = userGroupService.selectUserByCode(groupcode);
        int count = userGroupService.selectCountByCode(groupcode);
        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("code",0);
        returnMap.put("msg","");
        returnMap.put("count",count);
        returnMap.put("data",users);
        return returnMap;
    }

    @GetMapping("/getTree")
    @ResponseBody
    public List<Map<String,String>> getTree(){
        List<Group> groups = groupService.selectAllData();
        //拼装数据
        List<Map<String,String>> reGroups = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        for (Group group : groups){
            map = new HashMap<>();
            map.put("id",group.getGroupcode());
            map.put("label",group.getGroupname());
            reGroups.add(map);
        }
        return reGroups;
    }


}
