package com.wechat.mgr.util;

import com.wechat.mgr.user.model.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {

    // 获取一个session对象
    private static HttpSession session = getSession();

    /**
     * user在session中的名字，也就是键值对的键。
     */
    private static final String USER_NAME_IN_SESSION = "user";

    /**
     * 获取session 的方法
     *
     * @return HttpSession
     */
    public static HttpSession getSession() {
        HttpSession session = null;
        try {
            session = getRequest().getSession();
        } catch (Exception e) {
        }
        return session;
    }

    /**
     * 获取一个request对象的方法
     *
     * @return HttpServletRequest
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return (HttpServletRequest) attrs.getRequest();
    }

    /**
     * 从session中获取到当前用户
     *
     * @return
     */
    public static User getUserFromSession() {
        return (User) session.getAttribute(USER_NAME_IN_SESSION);
    }

    /**
     * 更新Session中的user
     *
     * @return
     */
    public static User updateUserInSession(User user) {
        // 直接放入user，顶替掉原来session中的user
        return putUserIntoSession(user);
    }

    /**
     * 将user放入Session对象中
     *
     * @param user 用户
     * @return
     */
    public static User putUserIntoSession(User user) {
        session.setAttribute(USER_NAME_IN_SESSION, user);
        return getUserFromSession();
    }


    /**
     * 从session中移除User对象
     *
     * @return
     */
    public static User removeUserFromSession() {
        User user = getUserFromSession();
        session.removeAttribute(USER_NAME_IN_SESSION);
        return user;
    }
}
