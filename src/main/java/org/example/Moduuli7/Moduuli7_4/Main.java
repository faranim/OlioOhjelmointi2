package org.example.Moduuli7.Moduuli7_4;

import org.example.Moduuli7.Moduuli7_4.View.CcView;
import org.example.Moduuli7.Moduuli7_4.sql.datasource.MariaDbJpaConnection;

public class Main {
    public static void main(String[] args) {
        boolean isConnected = MariaDbJpaConnection.getInstanceC() != null;
        System.out.println("Database connection successful: " + isConnected);
        //Connection c = MariaDbConnection.getConnection();
        CcView.launch(CcView.class);


    }
}
