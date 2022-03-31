/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tashima42.apimanager.views;

import com.tashima42.apimanager.repositories.Sqlite.EmployeeRepository;

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
        if(name == null) {
            throw new Error("Name is mandatory for login");
        }
        if(password == null) {
            throw new Error("Password is mandatory for login");
        }
        try {
            String employeePassword = this.employeeRepository.getByName(name).getPassword();
            return password.equals(employeePassword);
        } catch(Error e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
