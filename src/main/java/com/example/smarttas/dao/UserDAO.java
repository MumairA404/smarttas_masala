package com.example.smarttas.dao;

import com.example.smarttas.database.Database;
import com.example.smarttas.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

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
}
