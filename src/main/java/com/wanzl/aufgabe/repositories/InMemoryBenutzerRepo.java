package com.wanzl.aufgabe.repositories;

import com.wanzl.aufgabe.Benutzer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InMemoryBenutzerRepo implements BenutzerRepo{

    private Map<String, Benutzer> benutzerMap = new HashMap<>();

    @Override
    public Benutzer save(Benutzer benutzer) {
        String uuid = UUID.randomUUID().toString();
        benutzer.setId(uuid);
        benutzerMap.put(uuid, benutzer);
        return benutzer;
    }

    @Override
    public Benutzer getBenutzer(String anmeldename) {
        for (Benutzer benutzer : benutzerMap.values()){
            if (benutzer.getEmail().equals(anmeldename) || benutzer.getNickname().equals(anmeldename)){
                return benutzer;
            }
        }
        return null;
    }

    @Override
    public Benutzer getBenutzerById(String userId) {
        return benutzerMap.get(userId);
    }
}
