package com.wechat.mgr.group.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usergroup")
public class UserGroupController {

    @RequestMapping("/toMain")
    public String toMain(){
        return "/usergroup/main";
    }

    @RequestMapping("/toShowInput")
    public String toShowInput(){
        return "/usergroup/input";
    }



}
