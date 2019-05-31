package com.wechat.mgr.login.controller;

import com.wechat.mgr.user.service.UserPWDService;
import com.wechat.mgr.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    private UserPWDService userPWDService;

    /**
     * 登录方法
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView("login/login");
        return mav;
    }

    /**
     * 主页
     * @return
     */
    @RequestMapping("/main")
    public ModelAndView main(@RequestParam("usercode") String usercode,@RequestParam("password") String password){
        //与数据库做验证
        String pwd = userPWDService.selectPwdByUserCode(usercode);
        if(pwd==password||pwd.equals(password)){

            ModelAndView mav = new ModelAndView("main/main");
            return mav;
        }else{
            return null;
        }
    }
}
