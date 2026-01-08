package com.example.smarttas.dao;

import com.example.smarttas.database.Database;
import com.example.smarttas.models.Leerling;
import com.example.smarttas.session.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LeerlingDAO {

    public boolean voegToe(Leerling leerling) {
        String sql = "INSERT INTO leerlingen (voornaam, achternaam, klas, docent) VALUES (?, ?, ?, ?)";
        int docentId = Session.getInstance().getIngelogdeDocent().getuserid();

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, leerling.getVoornaam());
            pstmt.setString(2, leerling.getAchternaam());
            pstmt.setString(3, leerling.getKlas());
            pstmt.setInt(4, docentId);
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
