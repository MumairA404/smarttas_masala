package com.example.smarttas.dao;

import com.example.smarttas.database.Database;
import com.example.smarttas.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

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
    public static boolean checkLogin(String email, String wachtwoord) {
        String sql = "SELECT * FROM user WHERE email = ? AND wachtwoord = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, wachtwoord);

            ResultSet rs = stmt.executeQuery();

            return rs.next(); // true als er een record is

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
