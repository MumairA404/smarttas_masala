package com.example.smarttas.controllers;

import com.example.smarttas.dao.LeerlingDAO;
import com.example.smarttas.models.Leerling;
import com.example.smarttas.session.Session;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
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

    private LeerlingDAO leerlingDAO = new LeerlingDAO();

    @FXML
    public void initialize() {
        klasChoiceBox.getItems().addAll("8A", "8B", "8C", "8D");
        klasChoiceBox.setValue("8A");
    }

    @FXML
    private void onToevoegenClick() {
        String voornaam = voornaamField.getText().trim();
        String achternaam = achternaamField.getText().trim();
        String klas = klasChoiceBox.getValue();

        // Controleer of velden leeg zijn
        if (voornaam.isEmpty() || achternaam.isEmpty()) {
            javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.WARNING);
            alert.setTitle("Waarschuwing");
            alert.setHeaderText("Onvolledige gegevens");
            alert.setContentText("Vul zowel voornaam als achternaam in!");
            alert.showAndWait();
            return;
        }

        Leerling leerling = new Leerling(voornaam, achternaam, klas);
        boolean toegevoegd = leerlingDAO.voegToe(leerling);

        if (toegevoegd) {
            System.out.println("leerling is succesvol toegevoegd");

            // Velden leegmaken
            voornaamField.clear();
            achternaamField.clear();
            klasChoiceBox.setValue("8A");
        } else {
            javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
            alert.setTitle("Fout");
            alert.setHeaderText("Toevoegen mislukt");
            alert.setContentText("Er is een fout opgetreden bij het toevoegen van de leerling.");
            alert.showAndWait();
        }
    }

    @FXML
    private void onHomeClick() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/smarttas/home_page.fxml"));
            Stage stage = (Stage) voornaamField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onKlassenoverzichtClick() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/smarttas/klassenoverzicht.fxml"));
            Stage stage = (Stage) voornaamField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onUitloggenClick() {
        // 1. Sessie resetten
        Session.getInstance().clear();

        // 2. Terug naar loginpagina
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smarttas/loginpagina.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) homeButton.getScene().getWindow(); // of een andere knop/element van huidig scherm
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
