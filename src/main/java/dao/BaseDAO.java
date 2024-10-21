package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {

    private static final String DB_NAME = "drstone";
    private static final String DB_HOST = "localhost";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";

    public static Connection getCon() {
        Connection con = null;
        try {
            String url = "jdbc:mysql://" + DB_HOST + ":3306/" + DB_NAME + "?useUnicode=true&characterEncoding=UTF-8";
            con = DriverManager.getConnection(url, DB_USER, DB_PASS);
        } catch (SQLException e) {
            System.err.println("Error establishing database connection: " + e.getMessage());
            e.printStackTrace();
        }
        return con;
    }

    public static void closeCon(Connection con) {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            System.err.println("Error closing database connection: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

