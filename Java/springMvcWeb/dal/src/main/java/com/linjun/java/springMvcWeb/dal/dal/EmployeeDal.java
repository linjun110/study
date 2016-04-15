package com.linjun.java.springMvcWeb.dal.dal;

import com.linjun.java.springMvcWeb.dal.bo.Employee;
import com.linjun.java.springMvcWeb.dal.dao.IDao;
import com.linjun.java.springMvcWeb.dal.exceptions.BusinessException;
import com.linjun.java.springMvcWeb.dal.utils.CommonUtil;
import com.linjun.java.springMvcWeb.dal.utils.SystemConfig;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by linjun on 16/4/8.
 */
public class EmployeeDal {
    private static Logger logger = LogManager.getLogger(EmployeeDal.class);
    private static IDao dao = null;

    static {
        String daoClassName = SystemConfig.getConfig("dal", "daoClassName");
        try {
            Class<?> daoClass = Class.forName(daoClassName);
            dao = (IDao) daoClass.newInstance();
        }catch (ClassNotFoundException ex){
            logger.fatal("Dao class: " + daoClassName + " not found in dal.properties");
        }catch (IllegalAccessException ex2){
        }catch (InstantiationException ex3){
        }
    }

    public static List<Employee> getAll() {
        try{
            String sql = "select * from employee";
            logger.info("sql: " + sql);
            return getEmployeeFromResultSet(dao.query(sql));
        }catch (BusinessException e){
            logger.error("Failed to get by id, reason:" + e.getMessage());
        }
        return new ArrayList<Employee>();
    }

    public static Employee getById(String id) {
        try{
            String sql = "select * from employee where id='" + id + "'";
            logger.info("sql: " + sql);
            return getEmployeeFromResultSet(dao.query(sql)).get(0);
        }catch (BusinessException e){
            logger.error("Failed to get by id, reason:" + e.getMessage());
        }
        return null;
    }

    public static Employee getByName(String name){
        try{
            String sql = "select * from employee where name='" + name + "'";
            logger.info("sql: " + sql);
            return getEmployeeFromResultSet(dao.query(sql)).get(0);
        }catch (BusinessException e){
            logger.error("Failed to get employee by name, reason:" + e.getMessage());
        }
        return null;
    }

    private static List<Employee> getEmployeeFromResultSet(ResultSet rs){
        List<Employee> result = new ArrayList<Employee>();
        try{
            while(rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getString("id"));
                employee.setName(rs.getString("name"));
                employee.setPassword(rs.getString("password"));
                employee.setIdCard(rs.getString("idCard"));
                employee.setGender(rs.getInt("gender"));
                employee.setBirthday(rs.getLong("birthday"));
                employee.setRole(rs.getString("role"));
                employee.setEnabled(rs.getInt("enabled"));

                result.add(employee);
            }

            return result;
        }catch (SQLException e2){
            logger.error("Failed to get employee by name, reason:" + e2.getMessage());
        }
        return result;
    }

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
            dao.execute(sql);
        }catch (BusinessException e){
            logger.error("Failed to create employee, reason:" + e.getMessage());
        }
    }
}
