package com.example.smarttas.dao;


import com.example.smarttas.database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class smarttasDAO {

    public static void insertStatus(boolean status, int vaknr) {
        String sql = "UPDATE smarttas SET sensorstatus = ? WHERE vaknr = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setBoolean(1, status);
            stmt.setInt(2, vaknr);

            int rows = stmt.executeUpdate();
            if (rows == 0) {
                System.out.println("⚠ Geen rij geüpdatet (vaknr = " + vaknr + " bestaat niet)");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
