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

    // R
    public static Employee getById(String id) {
        try{
            String sql = "select * from employee where id='" + id + "'";
            logger.info("sql: " + sql);
            return getEmployeeFromResultSet(DaoImpl.getInstance().query(sql));
        }catch (BusinessException e){
            logger.error("Failed to get by id, reason:" + e.getMessage());
        }
        return null;
    }


    public static Employee getByName(String name){
        try{
            String sql = "select * from employee where name='" + name + "'";
            logger.info("sql: " + sql);
            return getEmployeeFromResultSet(DaoImpl.getInstance().query(sql));
        }catch (BusinessException e){
            logger.error("Failed to get employee by name, reason:" + e.getMessage());
        }
        return null;
    }
    // end of R

    private static Employee getEmployeeFromResultSet(ResultSet rs){
        try{
            if(!rs.next()) {
                return null;
            }

            Employee employee = new Employee();
            employee.setId(rs.getString("id"));
            employee.setName(rs.getString("name"));
            employee.setPassword(rs.getString("password"));
            employee.setIdCard(rs.getString("idCard"));
            employee.setGender(rs.getInt("gender"));
            employee.setBirthday(rs.getLong("birthday"));
            employee.setRole(rs.getString("role"));
            employee.setEnabled(rs.getInt("enabled"));
            return employee;
        }catch (SQLException e2){
            logger.error("Failed to get employee by name, reason:" + e2.getMessage());
        }
        return null;
    }

    // C
    public static void create(Employee employee) {
        try{
            String sql = "insert into employee(id, name, password, gender, birthday, idcard, role, enabled)" +
                    " values(\"" + CommonUtil.genUUID() +
                    "\", \"" + employee.getName() +
                    "\", \"" + employee.getPassword() +
                    "\", " + employee.getGender() +
                    ", \"" + employee.getBirthday() +
                    "\", \"" + employee.getIdCard() +
                    "\", \"" + employee.getRole() +
                    "\", " + employee.getEnabled() +
                    ")";
            logger.info("sql: " + sql);
            DaoImpl.getInstance().execute(sql);
        }catch (BusinessException e){
            logger.error("Failed to create employee, reason:" + e.getMessage());
        }
    }
    // end of C
}
