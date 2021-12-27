package com.wanzl.aufgabe.verwaltung;

import com.wanzl.aufgabe.Benutzer;
import com.wanzl.aufgabe.services.BenutzerService;

public class Verwaltung implements IVerwaltung{

    private BenutzerService benutzerService;

    public Verwaltung(BenutzerService benutzerService) {
        this.benutzerService = benutzerService;
    }

    @Override
    public Benutzer Aktueller_Benutzer(String token) {
        return benutzerService.getBenutzerFromToken(token);
    }

    @Override
    public void Umbenennen(String benutzerId, String email, String nickname) {
        benutzerService.emailUmbennen(benutzerId, email);
        benutzerService.nicknameUmbennen(benutzerId, nickname);
    }

    @Override
    public void Passwort_ändern(String benutzerId, String passwort) {

    }

    @Override
    public void Löschen(String benutzerId, String passwort) {

    }
}
