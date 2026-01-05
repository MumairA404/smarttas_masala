module com.example.smarttas {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires com.fazecast.jSerialComm;


    opens com.example.smarttas to javafx.fxml;
    opens com.example.smarttas.controllers to javafx.fxml;

    exports com.example.smarttas;
}