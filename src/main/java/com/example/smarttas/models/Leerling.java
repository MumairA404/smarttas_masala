package com.example.smarttas.models;

public class Leerling {
    private int id; // id uit de database, 0 als nog niet opgeslagen
    private String voornaam;
    private String achternaam;
    private String klas;

    public Leerling(String voornaam, String achternaam, String klas) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.klas = klas;
    }

    public Leerling(int id, String voornaam, String achternaam, String klas) {
        this.id = id;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.klas = klas;
    }

    // Getters en setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getVoornaam() { return voornaam; }
    public void setVoornaam(String voornaam) { this.voornaam = voornaam; }

    public String getAchternaam() { return achternaam; }
    public void setAchternaam(String achternaam) { this.achternaam = achternaam; }

    public String getKlas() { return klas; }
    public void setKlas(String klas) { this.klas = klas; }
}
