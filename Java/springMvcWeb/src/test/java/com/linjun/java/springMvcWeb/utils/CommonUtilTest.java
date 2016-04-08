package com.linjun.java.springMvcWeb.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import org.easymock.EasyMock;
import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.capture;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.*;
import static org.powermock.api.easymock.PowerMock.createMock;
import static org.powermock.api.easymock.PowerMock.expectLastCall;
import static org.powermock.api.easymock.PowerMock.expectNew;
import static org.powermock.api.easymock.PowerMock.replay;
import static org.powermock.api.easymock.PowerMock.verify;

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
}
