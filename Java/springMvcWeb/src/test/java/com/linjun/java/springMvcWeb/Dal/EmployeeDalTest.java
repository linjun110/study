package com.linjun.java.springMvcWeb.Dal;

import com.linjun.java.springMvcWeb.bo.Employee;
import com.linjun.java.springMvcWeb.dal.EmployeeDal;
import com.linjun.java.springMvcWeb.utils.CommonUtil;
import org.junit.Test;

import java.util.Date;

/**
 * Created by linjun on 16/4/9.
 */
public class EmployeeDalTest {
    @Test
    public void createEmployee(){
        Employee employee = new Employee();
        employee.setUuid(CommonUtil.genUUID());
        employee.setName("name");
        employee.setPassword("pw");
        employee.setIdCard("idCard");
        employee.setBirthday(new Date().getTime());
        employee.setGender(1);
        EmployeeDal.create(employee);
    }
}
