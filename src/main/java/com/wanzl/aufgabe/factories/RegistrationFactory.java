package com.wanzl.aufgabe.factories;

import com.wanzl.aufgabe.anmeldung.Anmeldung;
import com.wanzl.aufgabe.anmeldung.IAnmeldung;
import com.wanzl.aufgabe.registration.IRegistrierung;
import com.wanzl.aufgabe.registration.Registration;
import com.wanzl.aufgabe.services.BenutzerService;
import com.wanzl.aufgabe.services.BenutzerServiceImpl;
import com.wanzl.aufgabe.verwaltung.IVerwaltung;
import com.wanzl.aufgabe.verwaltung.Verwaltung;

import java.util.HashMap;
import java.util.Map;

public class RegistrationFactory {

    private final static Map<String, Object> singletonObjs = new HashMap<>();
    public static final String REGISTRIERUNG = "registrierung";
    public static final String BENUTZER_SERVICE = "benutzerService";
    public static final String ANMELDUNG = "anmeldung";
    public static final String VERWALTUNG = "verwaltung";

    public static final IRegistrierung getRegistrierung() {
        if (singletonObjs.get(REGISTRIERUNG) == null) {
            singletonObjs.put(REGISTRIERUNG, new Registration(RepoFactory.getBenuterRepo(), RepoFactory.getPasswordRepo()));
        }
        return (IRegistrierung) singletonObjs.get(REGISTRIERUNG);
    }

    public static BenutzerService createBenutzerService() {
        if (singletonObjs.get(BENUTZER_SERVICE) == null) {
            singletonObjs.put(BENUTZER_SERVICE, new BenutzerServiceImpl(
                    RepoFactory.getBenuterRepo(),
                    RepoFactory.getPasswordRepo(),
                    RepoFactory.getTokenRepo()
            )
            );
        }
        return (BenutzerService) singletonObjs.get(BENUTZER_SERVICE);
    }

    public static IAnmeldung getAnmeldung() {
        if(singletonObjs.get(ANMELDUNG) == null){
            singletonObjs.put(ANMELDUNG, new Anmeldung(createBenutzerService()));
        }
        return (IAnmeldung) singletonObjs.get(ANMELDUNG);
    }

    public static IVerwaltung getVerwaltung() {
        if(singletonObjs.get(VERWALTUNG) == null){
            singletonObjs.put(VERWALTUNG, new Verwaltung(createBenutzerService()));
        }
        return (IVerwaltung) singletonObjs.get(VERWALTUNG);
    }
}
