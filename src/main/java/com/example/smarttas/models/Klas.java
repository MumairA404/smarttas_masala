package com.example.smarttas.models;

public class Klas {
    private String klasid;
    private int aantalLeerlingen;

    public Klas(String klasid, int aantalLeerlingen) {
        this.klasid = klasid;
        this.aantalLeerlingen = aantalLeerlingen;
    }

    public String getKlasid() { return klasid; }
    public int getAantalLeerlingen() { return aantalLeerlingen; }
}
