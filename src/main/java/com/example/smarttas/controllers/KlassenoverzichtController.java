package com.example.smarttas.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;


public class KlassenoverzichtController {


    @FXML
    private Text klas8A;
    @FXML
    private Text klas8B;
    @FXML
    private Text klas8C;
    @FXML
    private Text klas8D;


    @FXML
    private Button homeButton;
    @FXML
    private Button klassenButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Button klastoevoegenButton;
    @FXML
    private Button leerlingtoevoegenButton;


    @FXML
    private Button bekijkButton1;
    @FXML
    private Button bekijkButton2;
    @FXML
    private Button bekijkButton3;
    @FXML
    private Button bekijkButton4;

    @FXML
    public void initialize() {
        System.out.println("KlassenoverzichtController geladen");
    }

    @FXML
    private void handleHome() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smarttas/home_page.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) homeButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Home geklikt");
    }


    @FXML
    private void handleleerlingtoevoegen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smarttas/leerling_toevoegen.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) leerlingtoevoegenButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Leerling toevoegen geklikt");
    }

    @FXML
    private void handleKlastoevoegen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smarttas/klas_toevoegen.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) klastoevoegenButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Klas toevoegen geklikt");
    }

    @FXML
    private void handleLogout() {
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

    @FXML
    private void handleBekijk1() {
        openLeerlingOverzicht();
    }

    @FXML
    private void handleBekijk2() {
        openLeerlingOverzicht();
    }

    @FXML
    private void handleBekijk3() {
        openLeerlingOverzicht();
    }

    @FXML
    private void handleBekijk4() {
        openLeerlingOverzicht();
    }

    private void openLeerlingOverzicht() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smarttas/leerling_overzicht.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) bekijkButton1.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Leerlingoverzicht geopend");
    }
}

