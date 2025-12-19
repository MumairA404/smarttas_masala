package com.example.smarttas.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;


public class RegisterController {

    @FXML private TextField voornaamField;
    @FXML private TextField achernaamField;
    @FXML private TextField emailField;
    @FXML private PasswordField wachtwoordField;
    @FXML private Button registreerButton;


    @FXML
    public void initialize(){
        System.out.println("RegisterController geladen");
    }

    @FXML
    private void handleRegister(){
        System.out.println(voornaamField.getText());
        System.out.println(emailField.getText());
    }

}
