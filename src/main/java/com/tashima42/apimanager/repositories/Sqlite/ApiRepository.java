/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tashima42.apimanager.repositories.Sqlite;

import com.tashima42.apimanager.entities.Api;
import com.tashima42.apimanager.entities.Team;
import com.tashima42.apimanager.entities.Employee;
import com.tashima42.apimanager.repositories.IApiRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tashima
 */
public class ApiRepository implements IApiRepository {

    private final Connection conn;

    public ApiRepository() {
        this.conn = Connect.connect();
    }

    @Override
    public ArrayList<Api> getAll() {
        String sql = "SELECT\n"
                + "     api.id AS id,\n"
                + "     api.name AS name,\n"
                + "     api.description,\n"
                + "     team.id AS team_id,\n"
                + "     team.name AS team_name,\n"
                + "     team.description AS team_description,\n"
                + "     employee.id AS owner_id,\n"
                + "     employee.name AS owner_name,\n"
                + "     employee.description AS owner_description,\n"
                + "     employee.role AS owner_role,\n"
                + "     employee.password AS owner_password\n"
                + "   FROM api\n"
                + "   JOIN employee, team\n"
                + "   WHERE\n"
                + "     api.owner = employee.id\n"
                + "   AND api.team = team.id;";

        ArrayList<Api> apis = new ArrayList<>();
        try ( PreparedStatement ptsmt = this.conn.prepareStatement(sql)) {
            ResultSet res = ptsmt.executeQuery();

            while (res.next()) {
                Integer id = res.getInt("id");
                String apiName = res.getString("name");
                String apiDescription = res.getString("description");

                String ownerName = res.getString("owner_name");
                String ownerDescription = res.getString("owner_description");
                String ownerRole = res.getString("owner_role");
                String ownerPassword = res.getString("owner_password");
                Integer ownerId = res.getInt("owner_id");

                String teamName = res.getString("team_name");
                String teamDescription = res.getString("team_description");
                Integer teamId = res.getInt("team_id");

                Employee owner = new Employee(ownerName, ownerDescription, ownerRole, ownerPassword, ownerId);
                Team team = new Team(teamName, teamDescription, null, teamId);
                Api api = new Api(apiName, apiDescription, owner, team, id);
                apis.add(api);
            }
            return apis;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Error("Failed to get apis");
        }
    }

    @Override
    public ArrayList<String> getNames() {
        String sql = "SELECT name FROM api;";
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
            throw new Error("Failed to get api names");
        }
    }

    @Override
    public ArrayList<Integer> getIds() {
        String sql = "SELECT id FROM api;";
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
            throw new Error("Failed to get api ids");
        }
    }

    @Override
    public void update(Api api) {
        String sql = "UPDATE api"
                + "     SET"
                + "     name = ?,"
                + "     description = ?,"
                + "     owner = ?,"
                + "     team = ?"
                + "     WHERE id = ?;";

        try ( PreparedStatement ptsmt = this.conn.prepareStatement(sql)) {
            ptsmt.setString(1, api.getName());
            ptsmt.setString(2, api.getDescription());
            ptsmt.setInt(3, api.getOwner().getId());
            ptsmt.setInt(4, api.getTeam().getId());
            ptsmt.setInt(5, api.getId());

            ptsmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Error("Failed to update api");
        }
    }

    @Override
    public void addApi(Api api) {
        String sql = "INSERT INTO api\n"
                + "     (name, description, owner, team)\n"
                + "     VALUES (?, ?, ?, ?);";

        try ( PreparedStatement pstmt = this.conn.prepareStatement(sql)) {
            pstmt.setString(1, api.getName());
            pstmt.setString(2, api.getDescription());
            pstmt.setInt(3, api.getOwner().getId());
            pstmt.setInt(4, api.getTeam().getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to add api");
        }
    }

    @Override
    public void removeApi(Integer id) {
        String sql = "DELETE FROM api WHERE id = ?";
        try ( PreparedStatement pstmt = this.conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to remove API");
        }
    }
}
