package com.example.smarttas.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;



public class HomeController {

    @FXML private Text welkomText;

    @FXML private Button bekijkButton;
    @FXML private Button homeButton;
    @FXML private Button klassenButton;
    @FXML private Button logoutButton;


    @FXML
    public void initialize(){
        welkomText.setText("Welkom Jan bij de overzicht van SmartTas");
    }

    @FXML
    private void handleBekijk(){
        System.out.println("Bekijk geklikt");
    }

    @FXML
    private void handleHome(){
        System.out.println("Home geklikt");
    }

    @FXML
    private void handleKlassen(){
        System.out.println("Klassenoverzicht geklikt");
    }

    @FXML
    private void handleLogout(){
        System.out.println("Uitloggen");
    }
}
