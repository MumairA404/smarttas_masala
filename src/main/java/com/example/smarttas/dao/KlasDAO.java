package com.example.smarttas.dao;

import com.example.smarttas.database.Database;
import com.example.smarttas.models.Klas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KlasDAO {

    public List<Klas> getAllKlassen() {
        List<Klas> klassen = new ArrayList<>();
        String sql = "SELECT klasid, aantal_leerlingen FROM klas"; // pas aan naar de kolomnamen in je tabel

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Klas klas = new Klas(
                        rs.getString("klasid"),  //klas naam
                        rs.getInt("aantal_leerlingen")     // aantal leerlingen
                );
                klassen.add(klas);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return klassen;
    }
}
