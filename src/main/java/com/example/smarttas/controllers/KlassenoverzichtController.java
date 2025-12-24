package com.example.smarttas.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;



public class KlassenoverzichtController {


    @FXML private Text klas8A;
    @FXML private Text klas8B;
    @FXML private Text klas8C;
    @FXML private Text klas8D;


    @FXML private Button homeButton;
    @FXML private Button klassenButton;
    @FXML private Button logoutButton;

    @FXML private Button bekijkButton1;
    @FXML private Button bekijkButton2;
    @FXML private Button bekijkButton3;
    @FXML private Button bekijkButton4;

    @FXML
    public void initialize(){
        System.out.println("KlassenoverzichtController geladen");
    }
    @FXML
    private void handleHome() {
        System.out.println("Home geklikt");
    }

    @FXML
    private void handleKlassen() {
        System.out.println("Klassenoverzicht geklikt");
    }

    @FXML
    private void handleLogout() {
        System.out.println("Uitloggen geklikt");
    }

    @FXML
    private void handleBekijk1() {
        System.out.println("Bekijk 8A geklikt");
    }

    @FXML
    private void handleBekijk2() {
        System.out.println("Bekijk 8B geklikt");
    }

    @FXML
    private void handleBekijk3() {
        System.out.println("Bekijk 8C geklikt");
    }

    @FXML
    private void handleBekijk4() {
        System.out.println("Bekijk 8D geklikt");
    }
}

