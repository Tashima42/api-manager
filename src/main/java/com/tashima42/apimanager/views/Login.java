/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tashima42.apimanager.views;

import com.tashima42.apimanager.repositories.Sqlite.EmployeeRepository;
import com.tashima42.apimanager.entities.Employee;
/**
 *
 * @author tashima
 */
public class Login {
    private final EmployeeRepository employeeRepository;

    public Login() {
        this.employeeRepository = new EmployeeRepository();
    }
    
    public Boolean login(String name, String password) {
        if(name.isEmpty()) {
            throw new Error("Name is mandatory for login");
        }
        if(password.isEmpty()) {
            throw new Error("Password is mandatory for login");
        }
        try {
            Employee employee = this.employeeRepository.getByName(name);
            
            if(employee == null) {
                throw new Error("Invalid Employee Name");
            }
            String employeePassword = employee.getPassword();
            
            return password.equals(employeePassword);
        } catch(Error e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
