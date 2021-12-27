package com.wanzl.aufgabe.repositories;

public interface PasswordRepo {

    public void saveBenutzerPassword(String benutzerId, String password);

    String getPassword(String id);
}
