package com.wanzl.aufgabe.repositories;

import java.util.HashMap;
import java.util.Map;

public class InMemoryTokenRepo implements TokenRepo{

    private Map<String, String> tokens = new HashMap<>();

    @Override
    public boolean hasToken(String token) {
        return tokens.keySet().contains(token);
    }

    @Override
    public void save(String benutzerId, String token) {
        tokens.put(token, benutzerId);
    }

    @Override
    public String getUserId(String token) {
        return tokens.get(token);
    }
}
