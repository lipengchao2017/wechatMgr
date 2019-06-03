package com.wechat.mgr.login.controller;

import com.wechat.mgr.user.model.User;
import com.wechat.mgr.user.model.UserPWD;
import com.wechat.mgr.user.service.UserPWDService;
import com.wechat.mgr.user.service.UserService;
import com.wechat.mgr.util.DateUtil;
import com.wechat.mgr.util.MD5Util;
import com.wechat.mgr.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.bind.annotation.*;
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
        String md5PWD = MD5Util.getMD5(password);
        String pwd = userPWDService.selectPwdByUserCode(usercode);
        if(pwd==md5PWD||pwd.equals(md5PWD)){
            User user = userService.selectByUsercode(usercode);
            ModelAndView mav = new ModelAndView("main/main");
            SessionUtil.putUserIntoSession(user);
            mav.addObject("loginUser",user);
            return mav;
        }else{
            ModelAndView mav = new ModelAndView("login/login");
            mav.addObject("error","密码错误，请确认后重试");
            return mav;
        }
    }

    /**
     * 跳转至密码页面
     * @return
     */
    @RequestMapping("/toPwd")
    public String toPWD(){
        return "login/changepwd";
    }

    /**
     * 修改密码
     * @return
     */
    @PostMapping("/updatepwd")
    @ResponseBody
    public String updatePWD(@RequestParam("oldpassword") String oldpassword,@RequestParam("newpassword")
                            String newpassword,@RequestParam("verifypassword") String verifypassword){

        if(!newpassword.equals(verifypassword)){
            return "diff";
        }else{
            String usercode = SessionUtil.getUserFromSession().getUsercode();
            UserPWD userPWD = new UserPWD();
            userPWD.setIsinitpwd(0);
            userPWD.setUserpwd(MD5Util.getMD5(newpassword));
            userPWD.setUsercode(usercode);
            userPWD.setId(userPWD.getUUID());
            userPWD.setIseffective(1);
            userPWD.setCreatetime(DateUtil.getDate());
            userPWD.setCreatorid(usercode);
            userPWD.setCreator(SessionUtil.getUserFromSession().getUsername());
            userPWDService.updateEffByCode(usercode);
            userPWDService.insertSelective(userPWD);

            return "success";
        }
    }

    /**
     * 验证旧密码
     * @return
     */
    @GetMapping("/verifyold")
    @ResponseBody
    public String verifyold(@RequestParam("oldpassword") String oldpassword){
        String usercode = SessionUtil.getUserFromSession().getUsercode();
        String md5PWD = MD5Util.getMD5(oldpassword);
        String pwd = userPWDService.selectPwdByUserCode(usercode);
        if(pwd==md5PWD||pwd.equals(md5PWD)){
            return "success";
        }else{
            return "fail";
        }
    }
}
