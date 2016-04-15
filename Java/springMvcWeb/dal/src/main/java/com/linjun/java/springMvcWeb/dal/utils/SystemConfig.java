package com.linjun.java.springMvcWeb.dal.utils;

import java.util.ResourceBundle;

/**
 * Created by linjun on 16/4/11.
 */
public class SystemConfig {
    // resources: [configFile].properties.
    public static String getConfig(String configFile, String itemIndex) {
        try {
            ResourceBundle resource = ResourceBundle.getBundle(configFile);
            return resource.getString(itemIndex);
        } catch (Exception e) {
            return "";
        }
    }
}
