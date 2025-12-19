package com.example.smarttas.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;



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
        String password = passwordField.getText();

        System.out.println("Email: " + email);
        System.out.println("Password " + password);
    }
    @FXML
    private void handleHome(){
        System.out.println("Home geklikt");
    }
    @FXML
    private void handleKlassen() {
        System.out.println("klassenoverzicht geklikt");
    }
}
