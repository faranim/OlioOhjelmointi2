package org.example.Moduuli7.Moduuli7_2.sql.dao;

import org.example.Moduuli7.Moduuli7_2.sql.datasource.MariaDbConnection;
import org.example.Moduuli7.Moduuli7_2.sql.entity.Currency;

import java.sql.*;
import java.util.ArrayList;

public class CurrencyDao {

    public Currency getCurrency(String code) {
        Connection conn = MariaDbConnection.getConnection();
        String sql = "SELECT abbreviation, c_name, rate FROM currency WHERE abbreviation = ?";

        double rate = 0;
        String c_name = null;
        String abbreviation = null;
        int count = 0;

        try {
            Statement s = conn.createStatement();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, code);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                count++;
                rate = rs.getDouble(3);
                c_name = rs.getString(2);
                abbreviation = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (count==1) {
            return new Currency(c_name, abbreviation, rate);
        }
        else {
            return null;
        }
    }

    public ArrayList<String> getCurrencyCodes() {
        Connection conn = MariaDbConnection.getConnection();
        String sql = "SELECT abbreviation FROM currency";
        ArrayList<String> codes = new ArrayList<String>();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                codes.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return codes;
    }

    public String connectionToString() {
        return MariaDbConnection.getConnection().toString();
    }
}
