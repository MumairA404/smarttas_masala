package com.example.smarttas.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class HomeController {

    @FXML private Text welkomText;

    @FXML private Button bekijkButton;
    @FXML private Button homeButton;
    @FXML private Button klassenButton;
    @FXML private Button logoutButton;


    @FXML
    public void initialize(){
        welkomText.setText("Welkom Jan bij de overzicht van SmartTas");
    }

    @FXML
    private void handleBekijk(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smarttas/klassenoverzicht.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) bekijkButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("bekijk geklikt");
    }

    @FXML
    private void handleHome(){
        System.out.println("Home geklikt");
    }

    @FXML
    private void handleKlassen(){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smarttas/klassenoverzicht.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage) klassenButton.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }

        System.out.println("Klassenoverzicht geklikt");
    }
    @FXML
    private void handleLogout(){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smarttas/loginpagina.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage) logoutButton.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        System.out.println("Uitloggen");
    }
}
