package com.example.smarttas.dao;

import com.example.smarttas.database.Database;
import com.example.smarttas.models.SensorStatus;
import com.example.smarttas.session.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SensorStatusDAO {

    public Boolean isTelefoonInTasVoorLeerling(int leerlingId) {

        String sql = """
            SELECT s.sensorstatus
            FROM smarttas s
            JOIN leerling l on l.smarttas = s.vaknr
            WHERE l.leerlingnr = ?
        """;

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, leerlingId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getBoolean("sensorstatus");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // geen smarttas gekoppeld
    }
}
