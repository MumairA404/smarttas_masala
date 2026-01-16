    package com.example.smarttas.controllers;

    import com.example.smarttas.dao.LeerlingDAO;
    import com.example.smarttas.models.Leerling;
    import com.example.smarttas.session.Session;
    import javafx.fxml.FXML;

    import javafx.scene.control.Button;
    import javafx.scene.control.ScrollPane;
    import javafx.scene.layout.ColumnConstraints;
    import javafx.scene.layout.GridPane;
    import javafx.scene.layout.VBox;
    import javafx.scene.text.Font;
    import javafx.scene.paint.Color;
    import javafx.scene.text.FontWeight;
    import javafx.scene.text.Text;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.stage.Stage;

    import java.io.IOException;
    import java.util.List;


    public class LeerlingoverzichtController {


        @FXML private Button homeButton;
        @FXML private Button klassenButton;
        @FXML private Button logoutButton;

        @FXML private Text klasText;
        @FXML private VBox leerlingenVBox;
        @FXML private ScrollPane leerlingenScrollPane;

        private String geselecteerdeKlas;


        @FXML
        public void initialize(){
            System.out.println("LeerlingoverzichtController");

        }
        public void setGeselecteerdeKlas(String klasNaam) {
            this.geselecteerdeKlas = klasNaam;
            klasText.setText("Klas: " + klasNaam);
            leerlingenVBox.getChildren().clear(); // hier
            buildHeader();
            loadLeerlingen();
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
            Session.getInstance().clear();
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
        private void openLeerlingStatus(Leerling leerling) {
            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("/com/example/smarttas/leerling_status.fxml")
                );
                Parent root = loader.load();

                LeerlingstatusController controller = loader.getController();
                controller.setLeerling(leerling); // ID / naam doorgeven

                Stage stage = (Stage) leerlingenVBox.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void loadLeerlingen() {

            List<Leerling> leerlingen =
                    new LeerlingDAO().getLeerlingenByKlas(geselecteerdeKlas);

            for (Leerling leerling : leerlingen) {

                GridPane row = new GridPane();
                row.setHgap(40);
                row.setStyle("-fx-padding: 10; -fx-background-color: black;");

                leerlingenScrollPane.setStyle("-fx-background: black; -fx-background-color: black;");
                leerlingenVBox.setStyle("-fx-background-color: black;");

                ColumnConstraints col1 = new ColumnConstraints(250);
                ColumnConstraints col2 = new ColumnConstraints(300);
                ColumnConstraints col3 = new ColumnConstraints(150);
                row.getColumnConstraints().addAll(col1, col2, col3);

                Text voornaamText = new Text(leerling.getVoornaam());
                voornaamText.setFill(Color.WHITE);
                voornaamText.setFont(Font.font(18));

                Text achternaamText = new Text(leerling.getAchternaam());
                achternaamText.setFill(Color.WHITE);
                achternaamText.setFont(Font.font(18));

                Button bekijkButton = new Button("Bekijk");
                bekijkButton.setPrefWidth(100);
                bekijkButton.setStyle(
                        "-fx-background-color: #2b2b2b;" +
                                "-fx-border-color: #78a0ff;" +
                                "-fx-text-fill: white;"
                );
                bekijkButton.setOnAction(e -> openLeerlingStatus(leerling));

                row.add(voornaamText, 0, 0);
                row.add(achternaamText, 1, 0);
                row.add(bekijkButton, 2, 0);

                leerlingenVBox.getChildren().add(row);
            }
        }


        private void buildHeader() {
            GridPane header = new GridPane();
            header.setHgap(40);
            header.setStyle("-fx-padding: 10; -fx-background-color: black;");

            header.getColumnConstraints().addAll(
                    new ColumnConstraints(250),
                    new ColumnConstraints(300),
                    new ColumnConstraints(150)
            );

            header.add(makeHeader("Voornaam"), 0, 0);
            header.add(makeHeader("Achternaam"), 1, 0);
            header.add(makeHeader("Bekijk"), 2, 0);

            leerlingenVBox.getChildren().add(header);
        }

        private Text makeHeader(String text) {
            Text t = new Text(text);
            t.setFill(Color.WHITE);
            t.setFont(Font.font("System", FontWeight.BOLD, 22));
            return t;
        }


    }
