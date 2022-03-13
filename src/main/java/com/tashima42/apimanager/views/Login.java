/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tashima42.apimanager.views;

import com.tashima42.apimanager.repositories.Sqlite.UserRepository;

/**
 *
 * @author tashima
 */
public class Login {
    private final UserRepository userRepository = new UserRepository();
    
    public Boolean login(String name, String password) {
        if(name == null) {
            throw new Error("Name is mandatory for login");
        }
        if(password == null) {
            throw new Error("Password is mandatory for login");
        }
        try {
            String userPassword = this.userRepository.findByName(name).getPassword();
            return password.equals(userPassword);
        } catch(Error e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
