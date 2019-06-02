package com.wechat.mgr.role.controller;

import com.alibaba.fastjson.JSONArray;
import com.wechat.mgr.role.model.Role;
import com.wechat.mgr.role.service.RoleService;
import com.wechat.mgr.util.DateUtil;
import com.wechat.mgr.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
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
    public ModelAndView toRoleMain(){
        ModelAndView mav = new ModelAndView("/role/main");
        mav.addObject("loginUser", SessionUtil.getUserFromSession());
        return mav;
    }

    /**
     * 显示台账数据
     * @return
     */
    @GetMapping(value = "/show")
    @ResponseBody
    public Map<String,Object> showDatas(@RequestParam("page") int page,@RequestParam("limit") int limit){
        int count = roleService.selectAllCount();
        List<Role> roles = roleService.selectAllWithPage((page-1)*10, limit);
        Map<String,Object> returnMap = new HashMap<>();
        returnMap.put("code",0);
        returnMap.put("msg","");
        returnMap.put("count",count);
        returnMap.put("data",roles);
        return returnMap;
    }

    /**
     * 角色删除
     * @param ids
     * @return
     */
    @PostMapping("/del")
    @ResponseBody
    public int delRoleData(@RequestParam("ids") String ids){
        JSONArray array = JSONArray.parseArray(ids);
        List<String> codeStrs = (List)array;
        int i = roleService.deleteByRolecodes(codeStrs);
        return i;
    }

    /**
     * 显示输入页面
     * @return
     */
    @RequestMapping("/showInput")
    public String showInput(){
        ModelAndView mav = new ModelAndView("/role/input");

        return "/role/input";
    }

    /**
     * 角色添加或编辑
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    public String saveRole(Role role){
        try {
            if (role.getId() == null || "".equals(role.getId())) {
                //添加
                role.setId(role.getUUID());
                role.setCreatetime(DateUtil.getDate());
                role.setCreatorid(SessionUtil.getUserFromSession().getUsercode());
                role.setCreator(SessionUtil.getUserFromSession().getUsername());
                roleService.insertSelective(role);
                return "asuccess";
            } else {
                //编辑
                role.setUpdatetime(DateUtil.getDate());
                role.setUpdatorid(SessionUtil.getUserFromSession().getUsercode());
                role.setUpdator(SessionUtil.getUserFromSession().getUsername());
                roleService.updateByPrimaryKeySelective(role);
                return "usuccess";
            }
        }catch (Exception e){
            return "fail";
        }
    }
}
