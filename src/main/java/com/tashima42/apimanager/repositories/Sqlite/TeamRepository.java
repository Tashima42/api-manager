/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tashima42.apimanager.repositories.Sqlite;

import com.tashima42.apimanager.entities.Team;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.tashima42.apimanager.repositories.ITeamRepository;
import java.util.ArrayList;

/**
 *
 * @author tashima
 */
public class TeamRepository implements ITeamRepository {

    private final Connection conn;

    public TeamRepository() {
        this.conn = Connect.connect();
    }

    @Override
    public Team findByName(String name) {
        String sql = "SELECT name, role, password \n"
                + "FROM employee where name = ?;";
        try ( PreparedStatement ptsmt = this.conn.prepareStatement(sql)) {
            ptsmt.setString(1, name);
            ResultSet res = ptsmt.executeQuery();
            String employeeName = res.getString("name");
            String employeeRole = res.getString("role");
            String employeePassword = res.getString("password");
            Team employee = new Team(employeeName, employeeRole, employeePassword);
            return employee;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Error("Employee not found");
        }
    }

    @Override
    public ArrayList<Team> getAll() {
        String sql = "SELECT name, description, role FROM employee;";
        
        ArrayList<Team> employees = new ArrayList<>();
        try ( PreparedStatement ptsmt = this.conn.prepareStatement(sql)) {
            ResultSet res = ptsmt.executeQuery();

            while (res.next()) {
                String name = res.getString("name");
                String description = res.getString("description");
                String role = res.getString("role");
                
                Team employee = new Employee(name, description, role, null);
                
                employees.add(employee);
            }
            return employees;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Error("Failed to get employees");
        }
    }

}
