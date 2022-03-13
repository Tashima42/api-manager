/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my_package;

import my_package.repositories.Sqlite.UserRepository;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 *
 * @author tashima
 */
public class User {

    private String name;
    private String role;
    private String password;
    private Connection conn = Connect.connect();
    private UserRepository userRepository = new UserRepository(this.conn);

    public User(String name, String role, String password) {
        this.name = name;
        this.role = role;
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public String getRole() {
        return this.role;
    }

    public String getPassword() {
        return this.password;
    }
    
    public static void main(String args[]) {
    }
}
