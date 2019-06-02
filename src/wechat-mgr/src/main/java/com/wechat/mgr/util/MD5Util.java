package com.wechat.mgr.util;

import org.springframework.util.DigestUtils;

public class MD5Util {

    public static String getMD5(String str) {
        String base = "pwd"+str;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
}
