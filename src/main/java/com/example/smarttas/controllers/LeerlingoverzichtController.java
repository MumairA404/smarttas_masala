package com.example.smarttas.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;



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

    @FXML
    public void initialize(){
        System.out.println("LeerlingoverzichtController");
        leerling1Voornaam.setText("");
        leerling1Achternaam.setText("");
    }

    @FXML private void handleHome() {
        System.out.println("Home geklikt");
    }

    @FXML private void handleKlassen() {
        System.out.println("Klassenoverzicht geklikt");
    }

    @FXML private void handleLogout() {
        System.out.println("Uitloggen geklikt");
    }

    // Bekijk-methodes
    @FXML private void handleBekijk1() { System.out.println("Bekijk leerling 1"); }
    @FXML private void handleBekijk2() { System.out.println("Bekijk leerling 2"); }
    @FXML private void handleBekijk3() { System.out.println("Bekijk leerling 3"); }
    @FXML private void handleBekijk4() { System.out.println("Bekijk leerling 4"); }
}
