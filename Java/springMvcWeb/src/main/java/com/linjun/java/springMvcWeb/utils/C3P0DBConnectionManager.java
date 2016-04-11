package com.linjun.java.springMvcWeb.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Created by linjun on 16/4/11.
 */
public class C3P0DBConnectionManager {
    private static ComboPooledDataSource cpds = null;

    public static void init() {
        String DRIVER_NAME = SystemConfig
                .getConfig("c3p0", "jdbc.driverClass");
        String DATABASE_URL = SystemConfig.getConfig("c3p0", "jdbc.url");
        String DATABASE_USER = SystemConfig
                .getConfig("c3p0", "jdbc.username");
        String DATABASE_PASSWORD = SystemConfig
                .getConfig("c3p0", "jdbc.password");
        int Min_PoolSize = 5;
        int Max_PoolSize = 50;
        int Acquire_Increment = 5;
        int Initial_PoolSize = 10;
        // 每隔3000s测试连接是否可以正常使用
        int Idle_Test_Period = 3000;
        // 每次连接验证连接是否可用
        String Validate = SystemConfig.getConfig("c3p0", "c3p0.validate");
        if (Validate.equals("")) {
            Validate = "false";
        }
        // 最小连接数
        try {
            Min_PoolSize = Integer.parseInt(SystemConfig.getConfig("c3p0", "c3p0.minPoolSize"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // 增量条数
        try {
            Acquire_Increment = Integer.parseInt(SystemConfig
                    .getConfig("c3p0", "c3p0.acquireIncrement"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // 最大连接数
        try {
            Max_PoolSize = Integer.parseInt(SystemConfig
                    .getConfig("c3p0", "c3p0.maxPoolSize"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // 初始化连接数
        try {
            Initial_PoolSize = Integer.parseInt(SystemConfig
                    .getConfig("c3p0", "c3p0.initialPoolSize"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // 每隔Idle_Test_Period s测试连接是否可以正常使用
        try {
            Idle_Test_Period = Integer.parseInt(SystemConfig
                    .getConfig("c3p0", "c3p0.idleConnectionTestPeriod"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            cpds = new ComboPooledDataSource();
            cpds.setDriverClass(DRIVER_NAME); // 驱动器
            cpds.setJdbcUrl(DATABASE_URL); // 数据库url
            cpds.setUser(DATABASE_USER); // 用户名
            cpds.setPassword(DATABASE_PASSWORD); // 密码
            cpds.setInitialPoolSize(Initial_PoolSize); // 初始化连接池大小
            cpds.setMinPoolSize(Min_PoolSize); // 最少连接数
            cpds.setMaxPoolSize(Max_PoolSize); // 最大连接数
            cpds.setAcquireIncrement(Acquire_Increment); // 连接数的增量
            cpds.setIdleConnectionTestPeriod(Idle_Test_Period); // 测连接有效的时间间隔
            cpds.setTestConnectionOnCheckout(Boolean.getBoolean(Validate)); // 每次连接验证连接是否可用
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {// 保证只进行一次初始化
            if (cpds == null) {
                init();
            }
            // 取得connection
            connection = cpds.getConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

    public static void release() {
        try {
            if (cpds != null) {
                cpds.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
