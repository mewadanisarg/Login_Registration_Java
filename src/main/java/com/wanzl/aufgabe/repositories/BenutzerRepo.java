package com.wanzl.aufgabe.repositories;

import com.wanzl.aufgabe.Benutzer;

public interface BenutzerRepo {
    public Benutzer save(Benutzer benutzer);

    Benutzer getBenutzer(String anmeldename);

    Benutzer getBenutzerById(String userId);
}
