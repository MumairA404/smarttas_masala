package com.example.smarttas.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import com.example.smarttas.models.User;
import com.example.smarttas.dao.UserDAO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;


public class RegisterController {

    @FXML private TextField voornaamField;
    @FXML private TextField achternaamField;
    @FXML private TextField emailField;
    @FXML private TextField jaarField;
    @FXML private TextField maandField;
    @FXML private TextField dagField;
    @FXML private PasswordField wachtwoordField;
    @FXML private Button registreerButton;


    @FXML
    public void initialize(){
        System.out.println("RegisterController geladen");
    }

    private void clearAll(){
        voornaamField.clear();
        achternaamField.clear();
        emailField.clear();
        dagField.clear();
        maandField.clear();
        jaarField.clear();
        wachtwoordField.clear();
    }

    private void gaNaarLogin() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/example/smarttas/loginpagina.fxml")
            );

            Parent root = loader.load();

            Stage stage = (Stage) voornaamField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleRegister() {
        System.out.println("Button geklikt");

        String voornaam = voornaamField.getText();
        String achternaam = achternaamField.getText();
        String email = emailField.getText();
        String rawPassword = wachtwoordField.getText();

        String geboortedatum =
                jaarField.getText() + "-" +
                        maandField.getText() + "-" +
                        dagField.getText();

        // 🔐 WACHTWOORD HASHEN
        String hashedPassword = BCrypt.hashpw(rawPassword, BCrypt.gensalt(12));

        User newUser = new User(
                voornaam,
                achternaam,
                email,
                hashedPassword,
                geboortedatum
        );

        UserDAO userDAO = new UserDAO();
        boolean success = userDAO.registerUser(newUser);

        if (success) {
            System.out.println("Registratie gelukt!");
            clearAll();
            gaNaarLogin();
        } else {
            System.out.println("Registratie mislukt...");
        }
    }

}
