package com.example.smarttas.dao;

import com.example.smarttas.database.Database;
import com.example.smarttas.models.Leerling;
import com.example.smarttas.session.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeerlingDAO {

    public boolean voegToe(Leerling leerling) {
        String sql = "INSERT INTO leerling (voornaam, achternaam, klas, docent) VALUES (?, ?, ?, ?)";
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
    public List<Leerling> getLeerlingenByKlas(String klas) {
        List<Leerling> leerlingen = new ArrayList<>();
        // hier database query
        String sql = "SELECT * FROM leerlingen WHERE klas = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, klas);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                leerlingen.add(new Leerling(
                        rs.getInt("id"),
                        rs.getString("voornaam"),
                        rs.getString("achternaam"),
                        rs.getString("klas")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return leerlingen;
    }
}
