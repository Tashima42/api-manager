/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tashima42.apimanager.repositories.Sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author tashima
 */
public class Connect {

    static Connection conn;

    public static final Connection connect() {
        if (Connect.conn != null) {
            return Connect.conn;
        } else {
            String url = "jdbc:sqlite:" + System.getProperty("user.dir") + "/database.db";
            try {
                Connection conn = DriverManager.getConnection(url);
                Connect.conn = conn;
                return Connect.conn;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    public static void prepare(Connection conn, Boolean dropTables, Boolean migrate, Boolean populate) {
        if (dropTables) {
            Connect.dropAllTables(conn);
        }
        
        if (migrate) {
            System.out.println("STARTED MIGRATIONS");
            Connect.migrate(conn);
            System.out.println("FINISHED MIGRATIONS");
        }
        if (populate) {
            System.out.println("STARTED POPULATION");
            Connect.populate(conn);
            System.out.println("FINISHED POPULATION");
        }
    }

    public static void migrate(Connection conn) {
        Connect.migrateEmployee(conn);
        Connect.migrateTeam(conn);
        Connect.migrateApi(conn);
    }

    public static void populate(Connection conn) {
        Connect.populateEmployee(conn);
        Connect.populateTeam(conn);
        Connect.populateApi(conn);
    }

    private static void dropAllTables(Connection conn) {
        try ( Statement stmt = conn.createStatement()) {
            stmt.execute("DROP TABLE api;");
            stmt.execute("DROP TABLE employee_team;");
            stmt.execute("DROP TABLE team;");
            stmt.execute("DROP TABLE employee;");
            System.out.println("Droped all tables");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void migrateEmployee(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS employee(\n"
                + "     id integer PRIMARY KEY,\n"
                + "     name text NOT NULL,\n"
                + "     description text NOT NULL,\n"
                + "     password text NOT NULL,\n"
                + "     role text NOT NULL\n"
                + ");";
        try ( Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Migrated employee");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void migrateTeam(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS team(\n"
                + "     id integer PRIMARY KEY,\n"
                + "     name text NOT NULL UNIQUE,\n"
                + "     description text NOT NULL,\n"
                + "     manager integer NOT NULL\n"
                + ");";
        try ( Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Migrated team");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void migrateApi(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS api(\n"
                + "     id integer PRIMARY KEY,\n"
                + "     name text NOT NULL UNIQUE,\n"
                + "     description text NOT NULL,\n"
                + "     owner text NOT NULL,\n"
                + "     team text NOT NULL,\n"
                + "     FOREIGN KEY (team) REFERENCES team (id),\n"
                + "     FOREIGN KEY (owner) REFERENCES employee (id)\n"
                + ");";
        try ( Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Migrated api");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void populateEmployee(Connection conn) {
        String sql = "INSERT INTO employee (name, role, password, description)\n"
                + "     VALUES (?, ?, ?, ?), (?, ?, ?, ?), (?, ?, ?, ?), (?, ?, ?, ?), (?, ?, ?, ?),\n"
                + "     (?, ?, ?, ?), (?, ?, ?, ?), (?, ?, ?, ?), (?, ?, ?, ?);";

        try ( PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "Rafael");
            pstmt.setString(2, "DEVELOPER");
            pstmt.setString(3, "password");
            pstmt.setString(4, "Software Developer");

            pstmt.setString(5, "Marcos");
            pstmt.setString(6, "DEVELOPER");
            pstmt.setString(7, "password");
            pstmt.setString(8, "Software Developer");

            pstmt.setString(9, "Fábio");
            pstmt.setString(10, "DEVELOPER");
            pstmt.setString(11, "password");
            pstmt.setString(12, "Software Developer");

            pstmt.setString(13, "Nolys");
            pstmt.setString(14, "DEVELOPER");
            pstmt.setString(15, "password");
            pstmt.setString(16, "Software Developer");

            pstmt.setString(17, "Giovanna");
            pstmt.setString(18, "DEVELOPER");
            pstmt.setString(19, "password");
            pstmt.setString(20, "Software Developer");

            pstmt.setString(21, "Mathias");
            pstmt.setString(22, "MANAGER");
            pstmt.setString(23, "password");
            pstmt.setString(24, "Staff Engineer");

            pstmt.setString(25, "Federico");
            pstmt.setString(26, "MANAGER");
            pstmt.setString(27, "password");
            pstmt.setString(28, "Project Manager");

            pstmt.setString(29, "José");
            pstmt.setString(30, "MANAGER");
            pstmt.setString(31, "password");
            pstmt.setString(32, "Comercial Director");

            pstmt.setString(33, "Fernando");
            pstmt.setString(34, "MANAGER");
            pstmt.setString(35, "password");
            pstmt.setString(36, "Logistics Coordinator");

            pstmt.executeUpdate();
            System.out.println("Populated employee");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void populateTeam(Connection conn) {
        String sql = "INSERT INTO team (name, description, manager)\n"
                + "     VALUES (?, ?, ?), (?, ?, ?), (?, ?, ?), (?, ?, ?), (?, ?, ?);";

        try ( PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "Alpha");
            pstmt.setString(2, "User specialists");
            pstmt.setInt(3, 6);

            pstmt.setString(4, "Bravo");
            pstmt.setString(5, "Payment providers");
            pstmt.setInt(6, 7);

            pstmt.setString(7, "Charlie");
            pstmt.setString(8, "Security nerds");
            pstmt.setInt(9, 3);

            pstmt.setString(10, "Delta");
            pstmt.setString(11, "Marketing providers");
            pstmt.setInt(12, 8);

            pstmt.setString(13, "Echo");
            pstmt.setString(14, "Shipment specialists");
            pstmt.setInt(15, 9);

            pstmt.executeUpdate();
            System.out.println("Populated team");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static void populateApi(Connection conn) {
        String sql = "INSERT INTO api\n"
                + "     (name, description, owner, team)\n"
                + "     VALUES (?, ?, ?, ?), (?, ?, ?, ?), (?, ?, ?, ?), (?, ?, ?, ?), (?, ?, ?, ?);";

        try ( PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "User Provisioning");
            pstmt.setString(2, "Create users and manage their data");
            pstmt.setInt(3, 2);
            pstmt.setInt(4, 1);

            pstmt.setString(5, "Payments");
            pstmt.setString(6, "Simple solution for in-app payments");
            pstmt.setInt(7, 3);
            pstmt.setInt(8, 2);

            pstmt.setString(9, "Authentication");
            pstmt.setString(10, "Easy token based authentication");
            pstmt.setInt(11, 4);
            pstmt.setInt(12, 3);

            pstmt.setString(13, "Notification");
            pstmt.setString(14, "Push notifications for users");
            pstmt.setInt(15, 5);
            pstmt.setInt(16, 4);

            pstmt.setString(17, "Freight");
            pstmt.setString(18, "Pricing, provisionment, etc");
            pstmt.setInt(19, 6);
            pstmt.setInt(20, 5);

            pstmt.executeUpdate();
            System.out.println("Populated api");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String args[]) {
        Connection connection = Connect.connect();
        Connect.prepare(connection, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }
}
