/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tashima42.apimanager.repositories.Sqlite;

import com.tashima42.apimanager.entities.Employee;
import com.tashima42.apimanager.entities.Maintenance;
import com.tashima42.apimanager.entities.Team;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.tashima42.apimanager.repositories.IMaintenanceRepository;
import java.util.ArrayList;

/**
 *
 * @author tashima
 */
public class MaintenanceRepository implements IMaintenanceRepository {

    private final Connection conn;

    public MaintenanceRepository() {
        this.conn = Connect.connect();
    }

    @Override
    public ArrayList<Maintenance> getAll() {
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

        ArrayList<Maintenance> maintenances = new ArrayList<>();
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
/*
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

    @Override
    public void removeTeam(Integer id) {
        String sql = "DELETE FROM team WHERE id = ?";
        try ( PreparedStatement pstmt = this.conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to remove TEAM");
        }
    }

    @Override
    public void update(Maintenance team) {
        String sql = "UPDATE team"
                + "     SET"
                + "     name = ?,"
                + "     description = ?,"
                + "     manager = ?"
                + "     WHERE id = ?;";

        try ( PreparedStatement ptsmt = this.conn.prepareStatement(sql)) {
            ptsmt.setString(1, team.getName());
            ptsmt.setString(2, team.getDescription());
            ptsmt.setInt(3, team.getManager().getId());
            ptsmt.setInt(4, team.getId());

            ptsmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Error("Failed to update team");
        }
    }

    @Override
    public void addTeam(Maintenance team) {
        String sql = "INSERT INTO team\n"
                + "     (name, description, manager)\n"
                + "     VALUES (?, ?, ?);";

        try ( PreparedStatement pstmt = this.conn.prepareStatement(sql)) {
            pstmt.setString(1, team.getName());
            pstmt.setString(2, team.getDescription());
            pstmt.setInt(3, team.getManager().getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to add team");
        }
    }
*/
}
