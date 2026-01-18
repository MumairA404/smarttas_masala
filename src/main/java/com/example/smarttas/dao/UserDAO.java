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

    public static User login(String email, String ingevoerdWachtwoord) {

        String sql = "SELECT * FROM user WHERE email = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {
                return null; // gebruiker niet gevonden
            }

            String dbWachtwoord = rs.getString("wachtwoord");
            boolean loginGeslaagd = false;

            // 1️⃣ NIEUW: bcrypt-wachtwoord
            if (dbWachtwoord != null && dbWachtwoord.startsWith("$2")) {
                loginGeslaagd = BCrypt.checkpw(ingevoerdWachtwoord, dbWachtwoord);
            }
            // 2️⃣ OUD: plain text wachtwoord
            else {
                loginGeslaagd = ingevoerdWachtwoord.equals(dbWachtwoord);

                // 🔄 MIGRATIE NAAR BCRYPT
                if (loginGeslaagd) {
                    String nieuwHash = BCrypt.hashpw(
                            ingevoerdWachtwoord,
                            BCrypt.gensalt(12)
                    );

                    String updateSql =
                            "UPDATE user SET wachtwoord = ? WHERE userid = ?";

                    try (PreparedStatement updateStmt =
                                 conn.prepareStatement(updateSql)) {

                        updateStmt.setString(1, nieuwHash);
                        updateStmt.setInt(2, rs.getInt("userid"));
                        updateStmt.executeUpdate();
                    }
                }
            }

            if (!loginGeslaagd) {
                return null;
            }

            // Login geslaagd → User object teruggeven
            return new User(
                    rs.getInt("userid"),
                    rs.getString("voornaam"),
                    rs.getString("achternaam"),
                    rs.getString("email"),
                    rs.getString("wachtwoord"), // inmiddels bcrypt
                    rs.getString("geboortedatum")
            );

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
