package com.example.smarttas.models;

public class User {
    private int userid;
    private String voornaam;
    private String achternaam;
    private String email;
    private String wachtwoord;
    private String geboortedatum; // bv. "YYYY-MM-DD"

    public User(int userid, String voornaam, String achternaam, String email, String wachtwoord, String geboortedatum) {
        this.userid = userid;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.email = email;
        this.wachtwoord = wachtwoord;
        this.geboortedatum = geboortedatum;
    }

    // getters
    public int getuserid() {return userid; }
    public String getVoornaam() { return voornaam; }
    public String getAchternaam() { return achternaam; }
    public String getEmail() { return email; }
    public String getWachtwoord() { return wachtwoord; }
    public String getGeboortedatum() { return geboortedatum; }
}
