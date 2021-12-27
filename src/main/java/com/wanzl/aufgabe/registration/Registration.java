package com.wanzl.aufgabe.registration;

import com.wanzl.aufgabe.Benutzer;
import com.wanzl.aufgabe.repositories.BenutzerRepo;
import com.wanzl.aufgabe.repositories.PasswordRepo;
import org.apache.commons.text.RandomStringGenerator;

import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
        if(passwort == null) {
            password = createRandomPassword();
        }

        passwordRepo.saveBenutzerPassword(benutzerRepo.save(benutzer).getId(), password);

    }

    private String createRandomPassword() {
        return new RandomStringGenerator.Builder().withinRange(33, 45).build().generate(10);
    }

    public String createTocken() {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        return null;
    }
    public static class EmailValidator{
        private final Pattern pattern;

        private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        public EmailValidator()
        {
            pattern = Pattern.compile(EMAIL_REGEX);
        }
        public boolean validate(final String email)
        {
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        }
    }
}
