package com.linjun.java.springMvcWeb.dal;

import com.linjun.java.springMvcWeb.dao.DaoImpl;
import com.linjun.java.springMvcWeb.bo.Cat;
import com.linjun.java.springMvcWeb.exceptions.BusinessException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by linjun on 16/4/8.
 */
public class CatDal {
    private static Logger logger = LogManager.getLogger(CatDal.class);

    public static Cat getCatById(int id) {
        ResultSet rs = null;

        long begin = System.currentTimeMillis();

        try{
            String sql = "select * from cat where id='" + id + "'";
            logger.info("sql: " + sql);
            rs = DaoImpl.getInstance().query(sql);
            Cat cat = new Cat();
            while (rs.next()) {
                cat.setId(rs.getInt("id"));
                cat.setName(rs.getString("name"));
            }
            long end = System.currentTimeMillis();
            logger.info("getCatById spend " + (end - begin) + "ms");
            return cat;
        }catch (BusinessException e){
            logger.error("Failed to get get cat by id, reason:" + e.getMessage());
        }catch (SQLException e2){
            logger.error("Failed to get get cat by id, reason:" + e2.getMessage());
        }
        return null;
    }
}
