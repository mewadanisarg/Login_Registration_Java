package com.wanzl.aufgabe.verwaltung;

import com.wanzl.aufgabe.Benutzer;

public interface IVerwaltung {

    Benutzer Aktueller_Benutzer(String token);

    void Umbenennen(String benutzerId, String email, String nickname);
    void Passwort_ändern(String benutzerId, String passwort);
    void Löschen(String benutzerId, String passwort);
}
