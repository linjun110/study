package com.linjun.java.springMvcWeb.dao;

/*sql*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*end of sql*/

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.linjun.java.springMvcWeb.exceptions.BusinessException;

/**
 * Created by linjun on 16/4/7.
 */
public class DaoImpl {
    private static Connection con = null;
    private static Statement st = null;
    private static DaoImpl _singleton = null;

    private static Logger logger = LogManager.getLogger(DaoImpl.class);

    private DaoImpl(){
    }
    public static DaoImpl getInstance() {
        if( _singleton == null){
            _singleton = new DaoImpl();
            try {
                connect2Db();
            } catch (BusinessException e) {
                logger.warn("got exception when conncting to db.");
            }
        }

        return _singleton;
    }
    private static void connect2Db() throws BusinessException {
        logger.debug("enter connect2Db.");
        if( st != null){
            try {
                logger.debug("st is not null, try to close.");
                st.close();
            } catch (SQLException e) {
                logger.warn("got exception when closing st.");
            }
        }
        if( con != null){
            try {
                logger.debug("con is not null, try to close.");
                con.close();
            } catch (SQLException e) {
                logger.warn("got exception when closing con.");
            }
        }
        try {
            logger.debug("Loading mysql jdbc");
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            logger.warn("got exception when loading mysql jdbc.");
            throw new BusinessException(null, "MYSQL", 1, "disconnect to mysql server");
            //e.printStackTrace();
        }

        try {
            logger.info("Connecting to db ...");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/springMvc", "root", "linjunAmazon");
            st = (Statement) con.createStatement();
            logger.info("Connected to db.");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            logger.warn("got exception when connecting to db.");
            throw new BusinessException(null, "MYSQL", 1, "disconnect to mysql server");
            //e.printStackTrace();
        }
    }
    private void dbValidChecker() throws BusinessException{
        if(con == null || st == null){
            logger.debug("con or st is null");
            if(con == null){
                logger.debug("con is null");
            }
            if(st == null){
                logger.debug("st is null");
            }
            connect2Db();
        }
    }


    public ResultSet query(String sql) throws BusinessException {
        logger.debug("enter query, sql: "+sql);
        dbValidChecker();
        ResultSet rs;
        try {
            rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            logger.warn("got SQLException when querying to db.");
            connect2Db();
            try {	// try again
                rs = st.executeQuery(sql);
                return rs;
            } catch (SQLException e1) {
                throw new BusinessException(e, "MYSQL", 1, e.getMessage());
            }
        }catch(NullPointerException e2){
            logger.fatal("got NullPointerException.");
            throw new BusinessException(e2, "MYSQL", 1, "NullPointerException");
        }
    }
    public void execute(String sql) throws BusinessException {
        logger.debug("enter execute, sql: "+sql);
        dbValidChecker();
        try {
            st.executeUpdate(sql);
        } catch (SQLException e) {
            logger.warn("got exception when executing to db.");
            connect2Db();
            try { // try again
                st.executeUpdate(sql);
            } catch (SQLException e1) {
                throw new BusinessException(e, "MYSQL", 1, e.getMessage());
            }
        } catch(NullPointerException e2){
            logger.fatal("got NullPointerException.");
            throw new BusinessException(e2, "MYSQL", 1, "NullPointerException");
        }
    }
}
