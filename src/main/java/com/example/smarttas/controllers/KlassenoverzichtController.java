package com.example.smarttas.controllers;

import com.example.smarttas.models.Klas;
import com.example.smarttas.dao.KlasDAO;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;


public class KlassenoverzichtController {

    @FXML
    private Button homeButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Button klastoevoegenButton;
    @FXML
    private Button leerlingtoevoegenButton;
    @FXML
    private VBox klassenVBox;
    @FXML
    private ScrollPane klassenScrollPane;


    @FXML
    public void initialize() {
        buildHeader();
        refreshKlassen();
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

    private void refreshKlassen() {
        List<Klas> klassen = new KlasDAO().getAllKlassen();

        for (Klas klas : klassen) {
            GridPane row = new GridPane();
            row.setHgap(40);
            row.setStyle("-fx-padding: 10; -fx-background-color: #000000;");

            klassenScrollPane.setStyle("-fx-background: black; -fx-background-color: black;");
            klassenVBox.setStyle("-fx-background-color: black;");

            ColumnConstraints col1 = new ColumnConstraints(220);
            ColumnConstraints col2 = new ColumnConstraints(300);
            ColumnConstraints col3 = new ColumnConstraints(200);
            row.getColumnConstraints().addAll(col1, col2, col3);

            Text klasText = new Text(klas.getKlasid());
            klasText.setFill(Color.WHITE);
            klasText.setFont(Font.font(18));

            Text aantalText = new Text(String.valueOf(klas.getAantalLeerlingen()));
            aantalText.setFill(Color.WHITE);
            aantalText.setFont(Font.font(18));

            Button bekijkButton = new Button("Bekijk");
            bekijkButton.setPrefWidth(100);
            bekijkButton.setStyle(
                    "-fx-background-color: #2b2b2b;" +
                            "-fx-border-color: #78a0ff;" +
                            "-fx-text-fill: white;"
            );
            bekijkButton.setOnAction(e -> openLeerlingOverzicht(klas.getKlasid()));

            row.add(klasText, 0, 0);
            row.add(aantalText, 1, 0);
            row.add(bekijkButton, 2, 0);

            klassenVBox.getChildren().add(row);
        }
    }

    private void openLeerlingOverzicht(String klasNaam) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/smarttas/leerling_overzicht.fxml"));
            Parent root = loader.load();

            LeerlingoverzichtController controller = loader.getController();
           controller.setGeselecteerdeKlas(klasNaam); // stuur de gekozen klas door

            Stage stage = (Stage) klassenVBox.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void buildHeader() {
        GridPane header = new GridPane();
        header.setHgap(40);
        header.setStyle("-fx-padding: 10; -fx-background-color: #000000;");

        ColumnConstraints col1 = new ColumnConstraints(220);
        ColumnConstraints col2 = new ColumnConstraints(300);
        ColumnConstraints col3 = new ColumnConstraints(200);
        header.getColumnConstraints().addAll(col1, col2, col3);

        Text klasHeader = new Text("Klas");
        klasHeader.setFill(Color.WHITE);
        klasHeader.setFont(Font.font("System", FontWeight.BOLD, 22));

        Text aantalHeader = new Text("Aantal leerlingen");
        aantalHeader.setFill(Color.WHITE);
        aantalHeader.setFont(Font.font("System", FontWeight.BOLD, 22));

        Text bekijkHeader = new Text("Bekijk leerlingen");
        bekijkHeader.setFill(Color.WHITE);
        bekijkHeader.setFont(Font.font("System", FontWeight.BOLD, 22));

        header.add(klasHeader, 0, 0);
        header.add(aantalHeader, 1, 0);
        header.add(bekijkHeader, 2, 0);

        klassenVBox.getChildren().add(header);
    }

}


