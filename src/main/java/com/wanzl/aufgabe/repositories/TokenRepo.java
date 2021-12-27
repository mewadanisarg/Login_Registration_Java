package com.wanzl.aufgabe.repositories;

public interface TokenRepo {
    boolean hasToken(String token);

    void save(String benutzerId, String token);

    String getUserId(String token);
}
