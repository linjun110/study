package com.linjun.java.springMvcWeb.dao;

import java.sql.ResultSet;
import com.linjun.java.springMvcWeb.exceptions.BusinessException;

/**
 * Created by linjun on 16/4/7.
 */
public interface IDao {
    public ResultSet query(String sql) throws BusinessException;
    public void execute(String sql) throws BusinessException;
}
