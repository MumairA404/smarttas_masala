package com.example.smarttas.dao;

import com.example.smarttas.database.Database;
import com.example.smarttas.models.Leerling;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LeerlingDAO {

    // Leerling toevoegen
    public boolean voegToe(Leerling leerling) {
        String sql = "INSERT INTO leerling (voornaam, achternaam, klas) VALUES (?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, leerling.getVoornaam());
            pstmt.setString(2, leerling.getAchternaam());
            pstmt.setString(3, leerling.getKlas());
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Je kan later extra methodes toevoegen, bijv. lijstAlleLeerlingen(), verwijderLeerling(), etc.
}
