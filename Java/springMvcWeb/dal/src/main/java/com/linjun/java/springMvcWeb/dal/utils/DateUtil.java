package com.linjun.java.springMvcWeb.dal.utils;

import java.util.Date;

/**
 * Created by linjun on 16/4/9.
 */
public class DateUtil {
    public static Date parseDateFromString(String d){
        String[] arr = d.split("-");
        Date date = new Date();
        date.setYear(Integer.parseInt(arr[0]));
        date.setMonth(Integer.parseInt(arr[1]));
        date.setDate(Integer.parseInt(arr[2]));
        return date;
    }
}
