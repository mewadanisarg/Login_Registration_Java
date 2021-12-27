package com.wanzl.aufgabe;

import com.wanzl.aufgabe.anmeldung.IAnmeldung;
import com.wanzl.aufgabe.factories.RegistrationFactory;
import com.wanzl.aufgabe.registration.IRegistrierung;
import com.wanzl.aufgabe.verwaltung.IVerwaltung;

public class UserRegistrationAndLogin {
    public static void main(String[] args) {
        IRegistrierung registrierung = RegistrationFactory.getRegistrierung();
        registrierung.Registrieren("test@test.com", "test_password", "nickname");

        IAnmeldung anmeldung = RegistrationFactory.getAnmeldung();
        String token = anmeldung.Anmelden("test@test.com", "test_password");
        Boolean isAnmeldungGültig = anmeldung.Ist_Anmeldung_gültig(token);
        System.out.println(isAnmeldungGültig);

        IVerwaltung verwaltung = RegistrationFactory.getVerwaltung();
        Benutzer benutzer = verwaltung.Aktueller_Benutzer(token);
        System.out.println(benutzer);

        verwaltung.Umbenennen(benutzer.getId(), "test1@test.com", "nickname1");
        System.out.println(verwaltung.Aktueller_Benutzer(token));

    }
}
