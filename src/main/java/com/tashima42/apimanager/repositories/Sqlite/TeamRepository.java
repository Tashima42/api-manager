/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tashima42.apimanager.repositories.Sqlite;

import com.tashima42.apimanager.entities.Employee;
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
    public Team getByName(String teamName) {
        String sql = "SELECT"
                + "     team.id AS id,"
                + "     team.name AS name,"
                + "     team.description AS description,"
                + "     employee.id as manager_id,"
                + "     employee.name AS manager_name,"
                + "     employee.description AS manager_description,"
                + "     employee.password AS manager_password,"
                + "     employee.role AS manager_role"
                + "   FROM team"
                + "   JOIN employee"
                + "   WHERE"
                + "     team.name = ? AND employee.id = team.manager;";
        try ( PreparedStatement ptsmt = this.conn.prepareStatement(sql)) {
            ptsmt.setString(1, teamName);
            ResultSet res = ptsmt.executeQuery();

            Integer id = res.getInt("id");
            String name = res.getString("name");
            String description = res.getString("description");
            
            Integer managerId = res.getInt("manager_id");
            String managerName = res.getString("manager_name");
            String managerDescription = res.getString("manager_description");
            String managerPassword = res.getString("manager_password");
            String managerRole = res.getString("manager_role");          

            Employee manager = new Employee(managerName, managerDescription, managerRole, managerPassword, managerId);
            
            return new Team(name, description, manager, id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Error("Employee not found");
        }
    }

    @Override
    public ArrayList<Team> getAll() {
        String sql = "SELECT"
                + "     team.name AS name,"
                + "     team.id AS id,"
                + "     team.description AS description,"
                + "     employee.name AS manager_name,"
                + "     employee.description AS manager_description,"
                + "     employee.password AS manager_password,"
                + "     employee.role AS manager_role,"
                + "     employee.id AS manager_id"
                + "   FROM team"
                + "   JOIN employee"
                + "   WHERE team.manager = employee.id;";

        ArrayList<Team> teams = new ArrayList<>();
        try ( PreparedStatement ptsmt = this.conn.prepareStatement(sql)) {
            ResultSet res = ptsmt.executeQuery();

            while (res.next()) {
                Integer id = res.getInt("id");
                String name = res.getString("name");
                String description = res.getString("description");

                String managerName = res.getString("manager_name");
                String managerDescription = res.getString("manager_description");
                String managerRole = res.getString("manager_role");
                Integer managerId = res.getInt("manager_id");
                String managerPassword = res.getString("manager_password");

                Employee manager = new Employee(managerName, managerDescription, managerRole, managerPassword, managerId);

                Team team = new Team(name, description, manager, id);

                teams.add(team);
            }
            return teams;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Error("Failed to get employees");
        }
    }

    @Override
    public ArrayList<String> getNames() {
        String sql = "SELECT name FROM team;";
        ArrayList<String> names = new ArrayList<>();
        try ( PreparedStatement ptsmt = this.conn.prepareStatement(sql)) {
            ResultSet res = ptsmt.executeQuery();

            while (res.next()) {
                String name = res.getString("name");
                names.add(name);
            }
            return names;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Error("Failed to get team names");
        }
    }

    @Override
    public ArrayList<Integer> getIds() {
        String sql = "SELECT id FROM team;";
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
            throw new Error("Failed to get team ids");
        }
    }
}
