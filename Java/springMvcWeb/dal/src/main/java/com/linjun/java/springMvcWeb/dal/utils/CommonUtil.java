package com.linjun.java.springMvcWeb.dal.utils;

import java.util.UUID;

/**
 * Created by linjun on 16/4/8.
 */
public class CommonUtil {
    public static String genUUID(){
        return UUID.randomUUID().toString();
    }
}
