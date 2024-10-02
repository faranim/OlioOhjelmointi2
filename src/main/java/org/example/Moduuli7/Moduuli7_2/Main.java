package org.example.Moduuli7.Moduuli7_2;

import org.example.Moduuli7.Moduuli7_2.sql.datasource.MariaDbConnection;
import org.example.Moduuli7.Moduuli7_2.View.CcView;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        //Connection c = MariaDbConnection.getConnection();
        CcView.launch(CcView.class);


    }
}
