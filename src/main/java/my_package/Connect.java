/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my_package;

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
            String url = "jdbc:sqlite:/home/tashima/projects/study/UTFPR/apoo/database.db";
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

    public static void prepare(Connection conn, Boolean migrate, Boolean populate) {
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
        Connect.migrateUser(conn);
        Connect.migrateTeam(conn);
        Connect.migrateUserTeam(conn);
        Connect.migrateApi(conn);
        Connect.migrateAccess(conn);
    }

    public static void populate(Connection conn) {
        Connect.populateUser(conn);
        Connect.populateTeam(conn);
        Connect.populateUserTeam(conn);
        Connect.populateApi(conn);
        Connect.populateAccess(conn);
    }

    private static void migrateUser(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS user(\n"
                + "     id integer PRIMARY KEY,\n"
                + "     name text NOT NULL,\n"
                + "     password text NOT NULL,\n"
                + "     role text NOT NULL\n"
                + ");";
        try ( Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Migrated user");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void migrateTeam(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS team(\n"
                + "     id integer PRIMARY KEY,\n"
                + "     name text NOT NULL UNIQUE,\n"
                + "     owner text NOT NULL\n"
                + ");";
        try ( Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Migrated team");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void migrateUserTeam(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS user_team(\n"
                + "     id integer PRIMARY KEY,\n"
                + "     team text NOT NULL,\n"
                + "     user text NOT NULL,\n"
                + "     FOREIGN KEY (team) REFERENCES team (id),\n"
                + "     FOREIGN KEY (user) REFERENCES user (id)\n"
                + ");";
        try ( Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Migrated user_team");
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
                + "     FOREIGN KEY (owner) REFERENCES user (id)\n"
                + ");";
        try ( Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Migrated api");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void migrateAccess(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS access(\n"
                + "     id integer PRIMARY KEY,\n"
                + "     api_key text NOT NULL UNIQUE,\n"
                + "     enabled boolean NOT NULL,\n"
                + "     api text NOT NULL,\n"
                + "     user text NOT NULL,\n"
                + "     FOREIGN KEY (api) REFERENCES api (id),\n"
                + "     FOREIGN KEY (user) REFERENCES user (id)\n"
                + ");";
        try ( Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Migrated access");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void populateUser(Connection conn) {
        String sql = "INSERT INTO user\n"
                + "     (name, role, password)\n"
                + "     VALUES (?, ?, ?)";

        try ( PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "user1");
            pstmt.setString(2, "MANAGER");
            pstmt.setString(3, "password");
            pstmt.executeUpdate();
            System.out.println("Populated user");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void populateTeam(Connection conn) {
        String sql = "INSERT INTO team\n"
                + "     (owner, name)\n"
                + "     VALUES (?, ?)";

        try ( PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, 1);
            pstmt.setString(2, "team1");
            pstmt.executeUpdate();
            System.out.println("Populated team");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void populateUserTeam(Connection conn) {
        String sql = "INSERT INTO user_team\n"
                + "     (team, user)\n"
                + "     VALUES (?, ?)";

        try ( PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, 1);
            pstmt.setInt(2, 1);
            pstmt.executeUpdate();
            System.out.println("Populated user_team");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void populateApi(Connection conn) {
        String sql = "INSERT INTO api\n"
                + "     (name, description, owner, team)\n"
                + "     VALUES (?, ?, ?, ?)";

        try ( PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "api1");
            pstmt.setString(2, "api1 description");
            pstmt.setInt(3, 1);
            pstmt.setInt(4, 1);
            pstmt.executeUpdate();
            System.out.println("Populated api");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void populateAccess(Connection conn) {
        String sql = "INSERT INTO access\n"
                + "     (api_key, enabled, api, user)\n"
                + "     VALUES (?, ?, ?, ?)";

        try ( PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "apikey1");
            pstmt.setBoolean(2, true);
            pstmt.setInt(3, 1);
            pstmt.setInt(4, 1);
            pstmt.executeUpdate();
            System.out.println("Populated access");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String args[]) {
        Connection conn = new Connect().conn;
        Connect.prepare(conn, Boolean.TRUE, Boolean.TRUE);
    }
}
