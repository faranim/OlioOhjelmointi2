package org.example.Moduuli7.Moduuli7_2.sql.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MariaDbConnection {

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn==null) {

            try {
                conn = DriverManager.getConnection(
                        "jdbc:mariadb://localhost:3306/currency_db?user=appuser&password=nimohanna");
            } catch (SQLException e) {
                System.out.println("Connection failed.");
                conn=null;
                e.printStackTrace();
            }
            System.out.println("Connection established");
            return conn;
        }
        else {
            return conn;
        }
    }

    public static void terminate() {
        try {
            getConnection().close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String toString() {
        return conn.toString();
    }
}
