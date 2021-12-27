package com.wanzl.aufgabe.anmeldung;

public interface IAnmeldung {
    String Anmelden(String anmeldename, String passwort);

    boolean Ist_Anmeldung_gültig(String token);
}
