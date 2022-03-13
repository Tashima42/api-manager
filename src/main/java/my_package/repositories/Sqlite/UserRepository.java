/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my_package.repositories.Sqlite;

import my_package.repositories.IUserRepository;
import my_package.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author tashima
 */
public class UserRepository implements IUserRepository {

    Connection conn;

    public UserRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public User findByName(String name) {
        String sql = "SELECT name, role, password \n"
                + "FROM user where name = ?;";
        try ( PreparedStatement ptsmt = this.conn.prepareStatement(sql)) {
            System.out.println("TEST");
            ptsmt.setString(1, name);
            ResultSet res = ptsmt.executeQuery();
            String userName = res.getString("name");
            String userRole = res.getString("role");
            String userPassword = res.getString("password");
            User user = new User(userName, userRole, userPassword);
            return user;
        } catch (SQLException e) {
            System.out.println("message");
            System.out.println(e.getMessage());
            throw new Error("User not found");
        }
    }
}
