package com.example.smarttas.controllers;

import com.example.smarttas.models.User;
import com.example.smarttas.session.Session;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;

import com.example.smarttas.dao.UserDAO;




public class LoginController {

    private boolean checkLogin() {

        if (Session.getInstance().getIngelogdeDocent() == null) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Toegang geweigerd");
            alert.setHeaderText("Niet ingelogd");
            alert.setContentText(
                    "Je hebt alleen toegang tot deze pagina als je bent ingelogd."
            );
            alert.showAndWait();

            return false;
        }

        return true;
    }



    @FXML private TextField emailField;
    @FXML private TextField passwordField;


    @FXML private Button loginButton;
    @FXML private Button homeButton;
    @FXML private Button KlassenButton;

    @FXML private ImageView logoImage;

    @FXML
    public void initialize() {

        System.out.println("LoginController geladen");
    }

    @FXML
    private void handleLogin() {
        String email = emailField.getText();
        String wachtwoord = passwordField.getText();

        User ingelogdeUser = UserDAO.login(email, wachtwoord);

        if (ingelogdeUser != null) {
            // Login geslaagd
            Session.getInstance().setIngelogdeDocent(ingelogdeUser); // opslaan in sessie

            // Ga door naar home page
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smarttas/home_page.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) emailField.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            }
            catch (IOException e) {
                e.printStackTrace();}

        } else {
            // Login mislukt
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fout");
            alert.setHeaderText("Login mislukt");
            alert.setContentText("Controleer je e-mail en wachtwoord.");
            alert.showAndWait();
        }
    }


    @FXML
    private void handleHome (){

            if (!checkLogin()) {
                return;
            }

            System.out.println("Home geklikt");


    }
    @FXML
    private void handleKlassen() {
        if (!checkLogin()) {
            return;
        }
        System.out.println("Klassenoverzicht geklikt");
    }
}
