/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tashima42.apimanager.views;

import com.tashima42.apimanager.entities.Api;
import com.tashima42.apimanager.entities.Employee;
import com.tashima42.apimanager.repositories.Sqlite.ApiRepository;
import com.tashima42.apimanager.repositories.Sqlite.EmployeeRepository;
import java.util.ArrayList;

/**
 *
 * @author tashima
 */
public class Main {

    private final ApiRepository apiRepository;
    private final EmployeeRepository employeeRepository;

    public Main() {
        this.apiRepository = new ApiRepository();
        this.employeeRepository = new EmployeeRepository();
    }

    public Object[][] getApisInfo() {
        ArrayList<Api> apis = apiRepository.getAll();
        Object[][] apisTableInfo = new Object[apis.size()][4];

        for (int i = 0; i < apis.size(); i++) {
            Api api = apis.get(i);

            apisTableInfo[i][0] = api.getName();
            apisTableInfo[i][1] = api.getDescription();
            apisTableInfo[i][2] = api.getTeam().getName();
            apisTableInfo[i][3] = api.getOwner().getName();
        }

        return apisTableInfo;
    }
    
    
    public Object[][] getTeamsInfo() {
        Object[][] teams = new Object[][]{
                {"Alpha", "User specialists", "Mathias"},
                {"Bravo", "Payment warriors", "Federico"},
                {"Charlie", "Security nerds", "Fábio"},
                {"Delta", "Marketing providers", "José"},
                {"Echo", "Downtime kings ", "Fernando"}
        };
        return teams;
    }

    public Object[][] getEmployeesInfo() {
        ArrayList<Employee> employees = employeeRepository.getAll();
        Object[][] employeesTableInfo = new Object[employees.size()][3];

        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);

            employeesTableInfo[i][0] = employee.getName();
            employeesTableInfo[i][1] = employee.getDescription();
            employeesTableInfo[i][2] = employee.getRole();
        }

        return employeesTableInfo;
    }
}
