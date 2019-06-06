package com.wechat.mgr.group.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/usergroup")
public class UserGroupController {

    @RequestMapping("/toMain")
    @ResponseBody
    public String toMain(){
        return "/usergroup/main";
    }





}
