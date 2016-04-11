package com.linjun.java.springMvcWeb.dao;

import com.linjun.java.springMvcWeb.exceptions.BusinessException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by linjun on 16/4/11.
 */
abstract public class AbstractBaseDao implements IDao{
    private static Logger logger = LogManager.getLogger(AbstractBaseDao.class);

    protected Connection con = null;
    protected Statement st = null;

    protected AbstractBaseDao(){
        prepare();
    }

    abstract protected void connect2Db();

    private boolean isDbActive(){
        return con != null && st != null;
    }

    private void prepare(){
        if(isDbActive()){
            return;
        }
        connect2Db();
    }

    public ResultSet query(String sql) throws BusinessException {
        logger.debug("sql: " + sql);

        prepare();

        ResultSet rs;

        try {
            rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            logger.warn("got SQLException when querying to db.");
            connect2Db();
            try {
                rs = st.executeQuery(sql);
                return rs;
            } catch (SQLException e1) {
                throw new BusinessException(null, "MYSQL", 1, "query failed");
            }
        }catch(NullPointerException e2){
            logger.fatal("got NullPointerException.");
            throw new BusinessException(null, "MYSQL", 1, "query failed");
        }
    }

    public void execute(String sql) throws BusinessException {
        logger.debug("sql: " + sql);

        prepare();

        try {
            st.executeUpdate(sql);
        } catch (SQLException e) {
            logger.warn("got exception when executing to db.");
            connect2Db();
            try {
                st.executeUpdate(sql);
            } catch (SQLException e1) {
                throw new BusinessException(null, "MYSQL", 1, "execute failed");
            }
        } catch(NullPointerException e2){
            logger.fatal("got NullPointerException.");
            throw new BusinessException(null, "MYSQL", 1, "execute failed");
        }
    }
}
