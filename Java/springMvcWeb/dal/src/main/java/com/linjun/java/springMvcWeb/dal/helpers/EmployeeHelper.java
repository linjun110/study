package com.linjun.java.springMvcWeb.dal.helpers;

import com.linjun.java.springMvcWeb.dal.bo.Employee;
import com.linjun.java.springMvcWeb.dal.dal.EmployeeDal;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.linjun.java.springMvcWeb.dal.utils.DateUtil;

/**
 * Created by linjun on 16/4/11.
 */
public class EmployeeHelper {
    private static Logger logger = LogManager.getLogger(EmployeeHelper.class);

    public static List<Employee> get(){
        return EmployeeDal.getAll();
    }


    public static void create(
            String username,
            String password,
            String idCard,
            Integer gender,
            String birthday,
            String role
    ){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Employee e = new Employee(username,
                passwordEncoder.encode(password),
                idCard,
                gender,
                DateUtil.parseDateFromString(birthday).getTime(),
                "ROLE_ADMIN", 1);
        EmployeeDal.create(e);
    }
}
