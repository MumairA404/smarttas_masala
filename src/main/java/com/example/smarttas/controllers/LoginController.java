package com.example.smarttas.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import com.example.smarttas.dao.UserDAO;

import java.io.IOException;



public class LoginController {


    @FXML private TextField emailField;
    @FXML private TextField passwordField;


    @FXML private Button loginButton;
    @FXML private Button homeButton;
    @FXML private Button KlassenButton;

    @FXML private ImageView logoImage;

    @FXML
    public void initialize() {

        System.out.println("LoginController geladen");
    }

    @FXML
    private void handleLogin(){
        String email = emailField.getText();
        String wachtwoord = passwordField.getText();

        boolean valid = UserDAO.checkLogin(email, wachtwoord);

        if (valid) {
            // Login geslaagd
            System.out.println("Login gelukt!");

            // Optioneel: doorsturen naar hoofdapp scherm
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smarttas/home_page.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage) emailField.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            // Login mislukt
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fout");
            alert.setHeaderText("Login mislukt");
            alert.setContentText("Controleer je e-mail en wachtwoord.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleHome (){
        System.out.println("Home geklikt");
    }
    @FXML
    private void handleKlassen() {
        System.out.println("Klassenoverzicht geklikt");
    }
}
