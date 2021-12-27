package com.wanzl.aufgabe.repositories;

import java.util.HashMap;
import java.util.Map;

public class InMemoryPasswordRepo implements PasswordRepo{

    private Map<String, String> stringPasswordMap = new HashMap<>();


    @Override
    public void saveBenutzerPassword(String benutzerId, String password) {
        stringPasswordMap.put(benutzerId, password);
    }

    @Override
    public String getPassword(String benutzerId) {
        return stringPasswordMap.get(benutzerId);
    }
}
