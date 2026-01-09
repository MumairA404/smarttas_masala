package com.example.smarttas;

import javafx.application.Application;
import com.fazecast.jSerialComm.SerialPort;
import java.sql.Connection;
import java.sql.SQLException;
import com.example.smarttas.hardware.Microbit;
import com.example.smarttas.database.Database;


public class Main {
    public static void main(String[] args) {
        testDatabaseConnection();
        listSerialPorts();

        Microbit microbit = new Microbit("COM4"); // kies juiste COM-poort
        microbit.startListening();


        Application.launch(HelloApplication.class, args);
    }
    private static void testDatabaseConnection() {
        try (Connection conn = Database.getConnection()) {
            System.out.println("Database connectie geslaagd!");
        } catch (SQLException e) {
            System.out.println("Fout bij verbinden met database:");
            e.printStackTrace();
        }
    }

    private static void listSerialPorts() {
        for (SerialPort port : SerialPort.getCommPorts()) {
            System.out.println(
                    "Poort: " + port.getSystemPortName() +
                            " | Beschrijving: " + port.getPortDescription()
            );
        }
    }

}
