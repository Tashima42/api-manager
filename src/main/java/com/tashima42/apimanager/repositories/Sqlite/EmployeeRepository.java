/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tashima42.apimanager.repositories.Sqlite;

import com.tashima42.apimanager.entities.Employee;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.tashima42.apimanager.repositories.IEmployeeRepository;
import java.util.ArrayList;

/**
 *
 * @author tashima
 */
public class EmployeeRepository implements IEmployeeRepository {

    private final Connection conn;

    public EmployeeRepository() {
        this.conn = Connect.connect();
    }

    @Override
    public Employee getByName(String employeeName) {
        String sql = "SELECT id, name, role, password, description \n"
                + "FROM employee where name = ?;";
        try ( PreparedStatement ptsmt = this.conn.prepareStatement(sql)) {
            ptsmt.setString(1, employeeName);
            ResultSet res = ptsmt.executeQuery();

            String name = res.getString("name");
            String role = res.getString("role");
            String password = res.getString("password");
            String description = res.getString("description");
            Integer id = res.getInt("id");

            Employee employee = new Employee(name, description, role, password, id);
            return employee;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Error("Employee not found");
        }
    }

    @Override
    public ArrayList<Employee> getAll() {
        String sql = "SELECT name, description, role, password, id FROM employee;";

        ArrayList<Employee> employees = new ArrayList<>();
        try ( PreparedStatement ptsmt = this.conn.prepareStatement(sql)) {
            ResultSet res = ptsmt.executeQuery();

            while (res.next()) {
                String name = res.getString("name");
                String description = res.getString("description");
                String role = res.getString("role");
                String password = res.getString("password");
                Integer id = res.getInt("id");

                Employee employee = new Employee(name, description, role, password, id);

                employees.add(employee);
            }
            return employees;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Error("Failed to get employees");
        }
    }

    @Override
    public ArrayList<String> getNames() {
        String sql = "SELECT name FROM employee;";
        ArrayList<String> names = new ArrayList<String>();
        try ( PreparedStatement ptsmt = this.conn.prepareStatement(sql)) {
            ResultSet res = ptsmt.executeQuery();

            while (res.next()) {
                String name = res.getString("name");
                names.add(name);
            }
            return names;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Error("Failed to get employee names");
        }
    }
    
    @Override
    public ArrayList<Integer> getIds() {
        String sql = "SELECT id FROM employee;";
        ArrayList<Integer> ids = new ArrayList<>();
        try ( PreparedStatement ptsmt = this.conn.prepareStatement(sql)) {
            ResultSet res = ptsmt.executeQuery();

            while (res.next()) {
                Integer id = res.getInt("id");
                ids.add(id);
            }
            return ids;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Error("Failed to get employee ids");
        }
    }
}
