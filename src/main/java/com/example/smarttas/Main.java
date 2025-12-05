package com.example.smarttas;

import javafx.application.Application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection connection;
        try {
            connection = DriverManager.getConnection(
                    "url",
                    "name",
                    "password"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Application.launch(HelloApplication.class, args);
    }
}
