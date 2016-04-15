package com.linjun.java.springMvcWeb.dal.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;

import java.util.Date;
import com.linjun.java.springMvcWeb.dal.utils.CommonUtil;

/**
 * Created by linjun on 16/4/8.
 */
public class CommonUtilTest {
    private static Logger logger = LogManager.getLogger(CommonUtilTest.class);

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void genUUID(){
        String uuid = CommonUtil.genUUID();
        logger.info("Generated UUID: " + uuid);

        assertNotEquals(uuid, "");
    }

    @Test
    public void test(){
        String dateStr = "2016-4-16";
        String[] arr = dateStr.split("-");
        Date d = new Date();
        logger.info(arr[0]);
        logger.info(arr[1]);
        logger.info(arr[2]);
        d.setYear(Integer.parseInt(arr[0]));
        d.setMonth(Integer.parseInt(arr[1]));
        d.setDate(Integer.parseInt(arr[2]));
        logger.info(d.getTime());
        Date e = new Date();
        e.setTime(d.getTime());

        logger.info(e.getYear());
        logger.info(e.getMonth());
        logger.info(e.getDate());
    }

    @Test
    public void encode(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        logger.info(passwordEncoder.encode("linjunpw"));
        logger.info(passwordEncoder.encode("linjunpw"));
        logger.info(passwordEncoder.encode("linjunpw"));

    }
}
