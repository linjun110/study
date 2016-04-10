package com.linjun.java.springMvcWeb.dal;

import com.linjun.java.springMvcWeb.bo.Employee;
import com.linjun.java.springMvcWeb.dao.DaoImpl;
import com.linjun.java.springMvcWeb.exceptions.BusinessException;
import com.linjun.java.springMvcWeb.utils.CommonUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by linjun on 16/4/8.
 */
public class EmployeeDal {
    private static Logger logger = LogManager.getLogger(EmployeeDal.class);

    // C
    public static Employee getByUUId(String uuid) {
        ResultSet rs = null;

        try{
            String sql = "select * from employee where id='" + uuid + "'";
            logger.info("sql: " + sql);
            rs = DaoImpl.getInstance().query(sql);
            Employee employee = new Employee();
            while (rs.next()) {
                employee.setUuid(rs.getString("id"));
                employee.setName(rs.getString("name"));
                employee.setPassword(rs.getString("pw"));
                employee.setIdCard(rs.getString("idCard"));
                employee.setGender(rs.getInt("gender"));
                employee.setBirthday(rs.getLong("birthday"));
            }
            return employee;
        }catch (BusinessException e){
            logger.error("Failed to get by id, reason:" + e.getMessage());
        }catch (SQLException e2){
            logger.error("Failed to get by id, reason:" + e2.getMessage());
        }
        return null;
    }

    public static void create(Employee employee) {
        try{
            String sql = "insert into employee(id, name, pw, gender, birthday, idcard)" +
                    " values(\"" + CommonUtil.genUUID() +
                    "\", \"" + employee.getName() +
                    "\", \"" + employee.getPassword() +
                    "\", " + employee.getGender() +
                    ", \"" + employee.getBirthday() +
                    "\", \"" + employee.getIdCard() +
                    "\")";
            logger.info("sql: " + sql);
            DaoImpl.getInstance().execute(sql);
        }catch (BusinessException e){
            logger.error("Failed to create employee, reason:" + e.getMessage());
        }
    }

    // R
    public static Employee getByNameAndPassword(String name, String password){
        ResultSet rs = null;

        try{
            String sql = "select * from employee where name='" + name + "' and pw='"+password+"'";
            logger.info("sql: " + sql);
            rs = DaoImpl.getInstance().query(sql);
            if(rs.next()) {
                Employee employee = new Employee();
                employee.setUuid(rs.getString("id"));
                employee.setName(rs.getString("name"));
                employee.setPassword(rs.getString("pw"));
                employee.setIdCard(rs.getString("idCard"));
                employee.setGender(rs.getInt("gender"));
                employee.setBirthday(rs.getLong("birthday"));
                return employee;
            }
            return null;
        }catch (BusinessException e){
            logger.error("Failed to get employee by name and password, reason:" + e.getMessage());
        }catch (SQLException e2){
            logger.error("Failed to get employee by name and password, reason:" + e2.getMessage());
        }
        return null;
    }

    public static Employee getByName(String name){
        ResultSet rs = null;

        try{
            String sql = "select * from employee where name='" + name + "'";
            logger.info("sql: " + sql);
            rs = DaoImpl.getInstance().query(sql);
            if(rs.next()) {
                Employee employee = new Employee();
                employee.setUuid(rs.getString("id"));
                employee.setName(rs.getString("name"));
                employee.setPassword(rs.getString("pw"));
                employee.setIdCard(rs.getString("idCard"));
                employee.setGender(rs.getInt("gender"));
                employee.setBirthday(rs.getLong("birthday"));
                return employee;
            }
            return null;
        }catch (BusinessException e){
            logger.error("Failed to get employee by name, reason:" + e.getMessage());
        }catch (SQLException e2){
            logger.error("Failed to get employee by name, reason:" + e2.getMessage());
        }
        return null;
    }
}
