package com.wanzl.aufgabe.services;

import com.wanzl.aufgabe.Benutzer;

public interface BenutzerService {

    public Boolean isBenutzerValid(String anmeldename, String password);

    String createToken();

    boolean isTokenGültig(String token);

    void saveToken(String benutzerId, String token);

    Benutzer getBenutzer(String anmeldename);

    Benutzer getBenutzerFromToken(String token);

    void emailUmbennen(String benutzerId, String email);

    void nicknameUmbennen(String benutzerId, String email);
}
