package com.wechat.mgr.util;

import java.util.Date;

public class DateUtil {

    public static Date getDate(){
        long l = System.currentTimeMillis();
        Date date= new Date(l);
        return date;
    }

}
