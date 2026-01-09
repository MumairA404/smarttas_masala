package com.example.smarttas.models;

public class User {
    private String voornaam;
    private String achternaam;
    private String email;
    private String wachtwoord;
    private String geboortedatum; // bv. "YYYY-MM-DD"

    public User(String voornaam, String achternaam, String email, String wachtwoord, String geboortedatum) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.email = email;
        this.wachtwoord = wachtwoord;
        this.geboortedatum = geboortedatum;
    }

    // getters
    public String getVoornaam() { return voornaam; }
    public String getAchternaam() { return achternaam; }
    public String getEmail() { return email; }
    public String getWachtwoord() { return wachtwoord; }
    public String getGeboortedatum() { return geboortedatum; }
}
