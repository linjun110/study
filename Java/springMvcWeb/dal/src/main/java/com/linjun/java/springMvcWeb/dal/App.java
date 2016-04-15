package com.linjun.java.springMvcWeb.dal;

import com.linjun.java.springMvcWeb.dal.bo.Employee;
import com.linjun.java.springMvcWeb.dal.helpers.EmployeeHelper;

import java.util.List;

/**
 * Created by linjun on 16/4/15.
 */
public class App {
    public static void main(String[] args){
        List<Employee> employees = EmployeeHelper.get();
        for(Employee e: employees) {
            System.out.println(e.getId());
            System.out.println(e.getName());
            System.out.println(e.getPassword());
            System.out.println(e.getIdCard());
        }
    }
}
