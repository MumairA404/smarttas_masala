package com.example.smarttas.dao;

import com.example.smarttas.database.Database;
import com.example.smarttas.models.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    // REGISTREREN – blijft hetzelfde
    public boolean registerUser(User user) {
        String sql = "INSERT INTO user (voornaam, achternaam, email, wachtwoord, geboortedatum) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getVoornaam());
            stmt.setString(2, user.getAchternaam());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getWachtwoord()); // ← gehashte versie
            stmt.setString(5, user.getGeboortedatum());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // LOGIN – AANGEPAST VOOR HASHING
    public static User login(String email, String ingevoerdWachtwoord) {

        String sql = "SELECT * FROM user WHERE email = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String hashedPassword = rs.getString("wachtwoord");

                // 🔐 HASH VERGELIJKEN
                if (BCrypt.checkpw(ingevoerdWachtwoord, hashedPassword)) {

                    return new User(
                            rs.getInt("userid"),
                            rs.getString("voornaam"),
                            rs.getString("achternaam"),
                            rs.getString("email"),
                            hashedPassword, // mag, maar niet nodig
                            rs.getString("geboortedatum")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // login mislukt
    }
}
