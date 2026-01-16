package com.example.smarttas.controllers;

import com.example.smarttas.session.Session;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

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
        openPage("/com/example/smarttas/home_page.fxml");
        System.out.println("Home geklikt");
    }

    @FXML
    private void onKlassenoverzichtClick() {
        openPage("/com/example/smarttas/klassenoverzicht.fxml");
        System.out.println("Klassenoverzicht geklikt");
    }

    @FXML
    private void onUitloggenClick() {
        Session.getInstance().clear();
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
