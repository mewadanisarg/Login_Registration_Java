package com.wanzl.aufgabe.registration;

import com.wanzl.aufgabe.Benutzer;
import com.wanzl.aufgabe.repositories.BenutzerRepo;
import com.wanzl.aufgabe.repositories.PasswordRepo;
import org.apache.commons.text.RandomStringGenerator;


public class Registration implements IRegistrierung {

    private BenutzerRepo benutzerRepo;
    private PasswordRepo passwordRepo;

    public Registration(BenutzerRepo benuterRepo, PasswordRepo passwordRepo) {
        this.benutzerRepo = benuterRepo;
        this.passwordRepo = passwordRepo;
    }

    @Override
    public void Registrieren(String email, String passwort, String nickname) {

        Benutzer benutzer = new Benutzer(email);
        benutzer.setNickname(nickname);
        String password = passwort;
        if (passwort == null) {
            password = createRandomPassword();
        }

        passwordRepo.saveBenutzerPassword(benutzerRepo.save(benutzer).getId(), password);

    }

    private String createRandomPassword() {
        return new RandomStringGenerator.Builder().withinRange(33, 45).build().generate(10);
    }
}
