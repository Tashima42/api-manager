/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tashima42.apimanager.entities;

/**
 *
 * @author tashima
 */
public class Employee {

    private String name;
    private String role;
    private String description;
    private String password;

    public Employee(String name, String description, String role, String password) {
        this.name = name;
        this.description = description;
        this.role = role;
        this.password = password;
    }

    public Employee(String name, String description, String role) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public String getRole() {
        return this.role;
    }
    public String getPassword() {
        return this.password;
    }
}
