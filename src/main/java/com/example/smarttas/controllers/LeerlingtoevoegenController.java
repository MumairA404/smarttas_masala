package com.example.smarttas.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class LeerlingtoevoegenController {

    @FXML
    private TextField voornaamField;


    @FXML
    private TextField achternaamField;


    @FXML
    private ChoiceBox<String> klasChoiceBox;

    @FXML
    private Button toevoegenButton;

    @FXML
    private Button homeButton;

    @FXML
    private Button klassenoverzichtButton;

    @FXML
    private Button uitloggenButton;



    @FXML
    public void initialize() {
        klasChoiceBox.getItems().addAll("8A", "8B", "8C", "8D");


        klasChoiceBox.setValue("8A");
    }
    @FXML
    private void onToevoegenClick() {

        String voornaam = voornaamField.getText();
        String achternaam = achternaamField.getText();
        String klas = klasChoiceBox.getValue();

        // Test output
        System.out.println("Nieuwe leerling:");
        System.out.println("Voornaam: " + voornaam);
        System.out.println("Achternaam: " + achternaam);
        System.out.println("Klas: " + klas);
    }

    @FXML
    private void onHomeClick() {
        System.out.println("Home knop geklikt");
    }

    @FXML
    private void onKlassenoverzichtClick() {
        System.out.println("Klassenoverzicht geklikt");
    }


    @FXML
    private void onUitloggenClick() {
        System.out.println("Uitloggen geklikt");
    }
}
