package com.wanzl.aufgabe.anmeldung;

import com.wanzl.aufgabe.Benutzer;
import com.wanzl.aufgabe.repositories.BenutzerRepo;
import com.wanzl.aufgabe.repositories.PasswordRepo;
import com.wanzl.aufgabe.services.BenutzerService;

public class Anmeldung implements IAnmeldung {

    private BenutzerService benutzerService;

    public Anmeldung(BenutzerService benutzerService) {
        this.benutzerService = benutzerService;
    }

    @Override
    public String Anmelden(String anmeldename, String passwort) {
        if (benutzerService.isBenutzerValid(anmeldename, passwort)){
            Benutzer benutzer = benutzerService.getBenutzer(anmeldename);
            String token = createToken(anmeldename);
            benutzerService.saveToken(benutzer.getId(), token);
            return token;
        }
        return null;
    }

    private String createToken(String anmeldename) {
        return benutzerService.createToken();
    }

    @Override
    public boolean Ist_Anmeldung_gültig(String token) {
        return benutzerService.isTokenGültig(token);
    }
}
