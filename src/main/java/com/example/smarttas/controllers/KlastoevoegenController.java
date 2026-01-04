package com.example.smarttas.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class KlastoevoegenController {

    @FXML
    private TextField klasNaamField;

    @FXML
    private TextField aantalLeerlingenField;

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
        System.out.println("Klas toevoegen scherm geladen");
    }
    @FXML
    private void onToevoegenClick() {

        String klasNaam = klasNaamField.getText();
        String aantalLeerlingen = aantalLeerlingenField.getText();

        System.out.println("Nieuwe klas:");
        System.out.println("Naam: " + klasNaam);
        System.out.println("Aantal leerlingen: " + aantalLeerlingen);
    }
    @FXML
    private void onHomeClick() {
        System.out.println("Home geklikt");
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
