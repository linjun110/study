package com.linjun.java.springMvcWeb.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created by linjun on 16/4/7.
 */
public class DaoImpl extends AbstractBaseDao implements IDao {
    private static Logger logger = LogManager.getLogger(DaoImpl.class);

    public DaoImpl() {
        super();
    }

    private void closeSt() {
        if (st == null) {
            return;
        }

        try {
            st.close();
        } catch (SQLException e) {
            logger.warn("got exception when closing st.");
        }

        st = null;
    }

    private void closeCon() {
        if (con == null) {
            return;
        }

        try {
            con.close();
        } catch (SQLException e) {
            logger.warn("got exception when closing con.");
        }

        con = null;
    }

    private void loadingJDBC() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            logger.warn("got exception when loading mysql jdbc.");
        }
    }

    private void getConAndSt() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/springMvcWeb?autoReconnect=true&useSSL=false", "root", "linjunAmazon");
            st = (Statement) con.createStatement();
            logger.info("Connected to db.");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            logger.warn("got exception when connecting to db.");
        }
    }

    protected void connect2Db() {
        logger.debug("connect to DB.");
        closeSt();
        closeCon();
        loadingJDBC();
        getConAndSt();
    }
}

