package com.example.smarttas.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;



public class LeerlingoverzichtController {


    @FXML private Button homeButton;
    @FXML private Button klassenButton;
    @FXML private Button logoutButton;


    @FXML private Button bekijkButton1;
    @FXML private Button bekijkButton2;
    @FXML private Button bekijkButton3;
    @FXML private Button bekijkButton4;


    @FXML private Text leerling1Voornaam;
    @FXML private Text leerling1Achternaam;

    @FXML private Text leerling2Voornaam;
    @FXML private Text leerling2Achternaam;

    @FXML private Text leerling3Voornaam;
    @FXML private Text leerling3Achternaam;

    @FXML private Text leerling4Voornaam;
    @FXML private Text leerling4Achternaam;


    @FXML
    public void initialize(){
        System.out.println("LeerlingoverzichtController");

    }

    @FXML private void handleHome() {
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

    @FXML private void handleKlassen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smarttas/klassenoverzicht.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) klassenButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Klassenoverzicht geklikt");
    }

    @FXML private void handleLogout() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smarttas/loginpagina.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) logoutButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Uitloggen geklikt");
    }


    // Bekijk-methodes
    @FXML private void handleBekijk1() {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smarttas/leerling_status.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) bekijkButton1.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    } catch (IOException e) {
        e.printStackTrace();
    }

        System.out.println("Leerlingstatus geopend");
    }

    @FXML private void handleBekijk2() {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smarttas/leerling_status.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) bekijkButton2.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    } catch (IOException e) {
        e.printStackTrace();
    }

        System.out.println("Leerlingstatus geopend");
    }

    @FXML private void handleBekijk3() {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smarttas/leerling_status.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) bekijkButton3.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    } catch (IOException e) {
        e.printStackTrace();
    }

        System.out.println("Leerlingstatus geopend");
    }

    @FXML private void handleBekijk4() {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smarttas/leerling_status.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) bekijkButton4.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    } catch (IOException e) {
        e.printStackTrace();
    }

        System.out.println("Leerlingstatus geopend");
    }

}
