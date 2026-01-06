package com.example.smarttas.session;

import com.example.smarttas.models.User;

public class Session {

    private static Session instance;
    private User ingelogdeDocent;

    private Session() { }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public User getIngelogdeDocent() {
        return ingelogdeDocent;
    }

    public void setIngelogdeDocent(User docent) {
        this.ingelogdeDocent = docent;
    }

    public void clear() {
        ingelogdeDocent = null;
    }
}
