package com.example.smarttas.hardware;

import com.example.smarttas.hardware.smarttasService;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

public class Microbit {

    private final SerialPort comPort;
    private final StringBuilder serialBuffer = new StringBuilder();

    public Microbit(String portName) {
        comPort = SerialPort.getCommPort(portName);
        comPort.setBaudRate(115200);
    }

    public void startListening() {
        if (!comPort.openPort()) {
            System.out.println("❌ Kan COM-poort niet openen");
            return;
        }

        System.out.println("✅ COM-poort geopend");

        comPort.addDataListener(new SerialPortDataListener() {
            @Override
            public int getListeningEvents() {
                return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
            }

            @Override
            public void serialEvent(SerialPortEvent event) {
                byte[] buffer = new byte[comPort.bytesAvailable()];
                int numRead = comPort.readBytes(buffer, buffer.length);

                if (numRead > 0) {
                    serialBuffer.append(new String(buffer, 0, numRead));

                    int newlineIndex;
                    while ((newlineIndex = serialBuffer.indexOf("\n")) != -1) {
                        String line = serialBuffer.substring(0, newlineIndex).trim();
                        serialBuffer.delete(0, newlineIndex + 1);

                        if (!line.isEmpty()) {
                            System.out.println("📥 " + line);

                            // Parsing: bepaal vaknr op basis van SensorX
                            int vaknr = 0;
                            if (line.startsWith("Sensor1")) vaknr = 1;
                            else if (line.startsWith("Sensor2")) vaknr = 2;
                            else if (line.startsWith("Sensor3")) vaknr = 3;

                            if (vaknr != 0) {
                                smarttasService.processLine(line, vaknr);
                            } else {
                                System.out.println("⚠ Onbekende sensor: " + line);
                            }
                        }
                    }
                }
            }
        });
    }
}
