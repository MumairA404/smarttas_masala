package com.example.smarttas.dao;

import com.example.smarttas.database.Database;
import com.example.smarttas.models.User; // of Docent, afhankelijk van je model
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    // Registreer blijft hetzelfde
    public boolean registerUser(User user) {
        String sql = "INSERT INTO user (voornaam, achternaam, email, wachtwoord, geboortedatum) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getVoornaam());
            stmt.setString(2, user.getAchternaam());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getWachtwoord());
            stmt.setString(5, user.getGeboortedatum());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Nieuwe login methode die het volledige User-object teruggeeft
    public static User login(String email, String wachtwoord) {
        String sql = "SELECT * FROM user WHERE email = ? AND wachtwoord = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, wachtwoord);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Maak User/Docent object aan
                return new User(
                        rs.getInt("userid"),
                        rs.getString("voornaam"),
                        rs.getString("achternaam"),
                        rs.getString("email"),
                        rs.getString("wachtwoord"), // evt niet nodig
                        rs.getString("geboortedatum")
                );
            } else {
                return null; // login mislukt
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
