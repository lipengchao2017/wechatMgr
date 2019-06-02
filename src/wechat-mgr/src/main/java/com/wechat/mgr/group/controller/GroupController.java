package com.wechat.mgr.group.controller;

import com.alibaba.fastjson.JSONArray;
import com.wechat.mgr.group.model.Group;
import com.wechat.mgr.group.service.GroupService;
import com.wechat.mgr.role.model.Role;
import com.wechat.mgr.util.DateUtil;
import com.wechat.mgr.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户组
 */
@Controller
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    /**
     * 用户组主页面
     * @return
     */
    @RequestMapping("/main")
    public ModelAndView toGroupMain(){
        ModelAndView mav = new ModelAndView("/group/main");
        return mav;
    }

    /**
     * 显示台账数据
     * @return
     */
    @GetMapping(value = "/show")
    @ResponseBody
    public Map<String,Object> showDatas(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int count = groupService.selectAllCount();
        List<Role> roles = groupService.selectAllWithPage((page-1)*10, limit);
        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("code",0);
        returnMap.put("msg","");
        returnMap.put("count",count);
        returnMap.put("data",roles);
        return returnMap;
    }

    /**
     * 用户组删除
     * @param ids
     * @return
     */
    @PostMapping("/del")
    @ResponseBody
    public int delRoleData(@RequestParam("ids") String ids){
        JSONArray array = JSONArray.parseArray(ids);
        List<String> codeStrs = (List)array;
        int i = groupService.deleteByGroupcodes(codeStrs);
        return i;
    }

    /**
     * 显示输入页面
     * @return
     */
    @RequestMapping("/showInput")
    public String showInput(){
        return "/group/input";
    }

    /**
     * 角色添加或编辑
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    public String saveGroup(Group group){
        try {
            if (group.getGroupid() == null || "".equals(group.getGroupid())) {
                //添加
                group.setGroupid(group.getUUID());
                group.setCreatetime(DateUtil.getDate());
                group.setCreatorid(SessionUtil.getUserFromSession().getUsercode());
                group.setCreator(SessionUtil.getUserFromSession().getUsername());
                groupService.insertSelective(group);
                return "asuccess";
            } else {
                //编辑
                group.setUpdatetime(DateUtil.getDate());
                group.setUpdatorid(SessionUtil.getUserFromSession().getUsercode());
                group.setUpdator(SessionUtil.getUserFromSession().getUsername());
                groupService.updateByPrimaryKeySelective(group);
                return "usuccess";
            }
        }catch (Exception e){
            return "fail";
        }
    }

}
