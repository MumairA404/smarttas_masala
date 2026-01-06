package com.example.smarttas.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


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

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smarttas/home_page.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) homeButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Home knop geklikt");
    }

        @FXML
    private void onKlassenoverzichtClick() {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smarttas/klassenoverzicht.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage) klassenoverzichtButton.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Klassenoverzicht geopend");
    }


    @FXML
    private void onUitloggenClick() {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smarttas/loginpagina.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage) uitloggenButton.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();



            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Uitloggen geklikt");
        }
    }
