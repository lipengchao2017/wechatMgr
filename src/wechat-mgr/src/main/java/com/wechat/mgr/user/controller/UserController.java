package com.wechat.mgr.user.controller;

import com.alibaba.fastjson.JSONArray;
import com.wechat.mgr.group.model.Group;
import com.wechat.mgr.role.model.Role;
import com.wechat.mgr.user.model.User;
import com.wechat.mgr.user.service.UserService;
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
 * 用户控制器
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户主页面
     * @return
     */
    @RequestMapping("/main")
    public ModelAndView toUserMain(){
        ModelAndView mav = new ModelAndView("/user/main");
        return mav;
    }

    /**
     * 显示台账数据
     * @return
     */
    @GetMapping(value = "/show")
    @ResponseBody
    public Map<String,Object> showDatas(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int count = userService.selectAllCount();
        List<Role> roles = userService.selectAllWithPage((page-1)*10, limit);
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
    public int delUserData(@RequestParam("ids") String ids){
        JSONArray array = JSONArray.parseArray(ids);
        List<String> codeStrs = (List)array;
        int i = userService.deleteByUsercodes(codeStrs);
        return i;
    }

    /**
     * 显示输入页面
     * @return
     */
    @RequestMapping("/showInput")
    public String showInput(){
        return "/user/input";
    }

    /**
     * 用户组添加或编辑
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    public String saveUser(User user){
        try {
            if (user.getUserid() == null || "".equals(user.getUserid())) {
                //添加
                user.setUserid(user.getUUID());
                user.setCreatetime(DateUtil.getDate());
                user.setCreatorid(SessionUtil.getUserFromSession().getUsercode());
                user.setCreator(SessionUtil.getUserFromSession().getUsername());
                userService.insertSelective(user);
                return "asuccess";
            } else {
                //编辑
                user.setUpdatetime(DateUtil.getDate());
                user.setUpdatorid(SessionUtil.getUserFromSession().getUsercode());
                user.setUpdator(SessionUtil.getUserFromSession().getUsername());
                userService.updateByPrimaryKeySelective(user);
                return "usuccess";
            }
        }catch (Exception e){
            return "fail";
        }
    }
}
