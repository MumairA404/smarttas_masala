package com.example.smarttas.models;

public class User {

    private int userid;
    private String voornaam;
    private String achternaam;
    private String email;
    private String wachtwoord;
    private String geboortedatum;

    // 🔹 Constructor voor REGISTREREN (id nog niet bekend)
    public User(String voornaam, String achternaam,
                String email, String wachtwoord, String geboortedatum) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.email = email;
        this.wachtwoord = wachtwoord;
        this.geboortedatum = geboortedatum;
    }

    // 🔹 Constructor voor LOGIN / DATABASE (id wél bekend)
    public User(int userid, String voornaam, String achternaam,
                String email, String wachtwoord, String geboortedatum) {
        this.userid = userid;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.email = email;
        this.wachtwoord = wachtwoord;
        this.geboortedatum = geboortedatum;
    }

    // 🔹 Getters
    public int getuserid() {
        return userid;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getEmail() {
        return email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public String getGeboortedatum() {
        return geboortedatum;
    }
}
