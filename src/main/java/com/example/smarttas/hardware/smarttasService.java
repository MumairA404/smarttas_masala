package com.example.smarttas.hardware;

import com.example.smarttas.dao.smarttasDAO;

public class smarttasService {

    private static final boolean INVERT_LOGIC = true;

    public static void processLine(String line, int vaknr) {
        line = line.trim();

        // haal alleen de 0 of 1 uit "SensorX:0"
        if (line.contains(":")) {
            String[] parts = line.split(":");
            line = parts[1].trim();
        }

        boolean status;
        if (line.equals("0")) {
            status = false;
        } else if (line.equals("1")) {
            status = true;
        } else {
            System.out.println("⚠ Ongeldige sensorwaarde: " + line);
            return;
        }

        if (INVERT_LOGIC) {
            status = !status;
        }

        smarttasDAO.insertStatus(status, vaknr);
        System.out.println("💾 Sensorstatus opgeslagen (vaknr " + vaknr + "): " + status);
    }
}