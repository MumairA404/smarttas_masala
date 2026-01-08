package com.example.smarttas.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class LeerlingstatusController {

    @FXML private Button homeButton;
    @FXML private Button klassenButton;
    @FXML private Button logoutButton;

    @FXML
    private void handleHome() {
        openPage("/com/example/smarttas/home_page.fxml");
        System.out.println("Home geklikt");
    }

    @FXML
    private void handleKlassen() {
        openPage("/com/example/smarttas/klassenoverzicht.fxml");
        System.out.println("Klassenoverzicht geklikt");
    }

    @FXML
    private void handleLogout() {
        openPage("/com/example/smarttas/loginpagina.fxml");
        System.out.println("Uitloggen geklikt");
    }

    private void openPage(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            Stage stage = (Stage) homeButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
