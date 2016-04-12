package com.linjun.java.springMvcWeb.dao;

import com.linjun.java.springMvcWeb.exceptions.BusinessException;
import com.linjun.java.springMvcWeb.utils.C3P0DBConnectionManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;

/**
 * Created by linjun on 16/4/11.
 */
public class C3p0DaoImpl extends AbstractBaseDao implements IDao{
    private static Logger logger = LogManager.getLogger(C3p0DaoImpl.class);

    protected Connection con = null;
    protected Statement st = null;

    public C3p0DaoImpl(){
        super();
    }

    protected void connect2Db(){
        C3P0DBConnectionManager.init();
        try {
            con = C3P0DBConnectionManager.getConnection();
            st = (Statement) con.createStatement();
        } catch (SQLException e) {
            logger.fatal("fail to get connection or create statement.");
        }
    }
}
