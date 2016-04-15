package com.linjun.java.springMvcWeb.dal.dao;

import com.linjun.java.springMvcWeb.dal.exceptions.BusinessException;

import java.sql.ResultSet;

/**
 * Created by linjun on 16/4/7.
 */
public interface IDao {
    public ResultSet query(String sql) throws BusinessException;
    public void execute(String sql) throws BusinessException;
}
