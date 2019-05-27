package com.wechat.mgr.login.controller;

import com.wechat.mgr.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * 登录控制器
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 登录方法
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView("login/login");
        List<String> userList = new ArrayList<String>();
        userList.add("admin");
        userList.add("user1");
        userList.add("user2");
        mav.addObject("userList",userList);
        return mav;
    }

    /**
     * 主页
     * @return
     */
    @RequestMapping("/main")
    public ModelAndView main(){
        //与数据库做验证


        //不做验证直接跳转
        ModelAndView mav = new ModelAndView("main/main");

        return mav;
    }




}
