package com.example.smarttas.controllers;

import com.example.smarttas.session.Session;
import com.example.smarttas.dao.SensorStatusDAO;
import com.example.smarttas.models.Leerling;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;


public class LeerlingstatusController {

    @FXML private Button homeButton;
    @FXML private Button klassenButton;
    @FXML private Button logoutButton;
    @FXML private Label labelNietInTas;
    @FXML private Label labelInTas;
    @FXML private Text leerlingText;
    private Leerling leerling;

    @FXML
    public void initialize() {
        System.out.println("Leerling status is ingeladen");
    }

    public void setLeerling(Leerling leerling) {
        this.leerling = leerling;
        leerlingText.setText(
            "SmartTas van " + leerling.getVoornaam() + " " + leerling.getAchternaam()
        );
        updateStatus();
    }



    private void updateStatus() {

        labelInTas.setVisible(false);
        labelNietInTas.setVisible(false);

        Boolean telefoonInTas =
                new SensorStatusDAO().isTelefoonInTasVoorLeerling(2);

        if (telefoonInTas == null) {
            labelNietInTas.setText("Geen SmartTas gekoppeld");
            labelNietInTas.setVisible(true);
            return;
        }

        if (telefoonInTas) {
            labelInTas.setVisible(true);
        } else {
            labelNietInTas.setVisible(true);
        }
    }


    @FXML
    private void handleHome() {
        openPage("/com/example/smarttas/home_page.fxml");
        System.out.println("Home geklikt");
    }

    @FXML
    private void handleKlassen() {
        openPage("/com/example/smarttas/klassenoverzicht.fxml");
        System.out.println("Klassenoverzicht geklikt");
    }

    @FXML
    private void handleLogout() {
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
