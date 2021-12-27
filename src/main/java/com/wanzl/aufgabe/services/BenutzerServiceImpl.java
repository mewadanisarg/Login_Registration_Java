package com.wanzl.aufgabe.services;

import com.wanzl.aufgabe.Benutzer;
import com.wanzl.aufgabe.repositories.BenutzerRepo;
import com.wanzl.aufgabe.repositories.PasswordRepo;
import com.wanzl.aufgabe.repositories.TokenRepo;
import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;

public class BenutzerServiceImpl implements BenutzerService{
    private BenutzerRepo benuterRepo;
    private PasswordRepo passwordRepo;
    private TokenRepo tokenRepo;

    public BenutzerServiceImpl(BenutzerRepo benuterRepo, PasswordRepo passwordRepo, TokenRepo tokenRepo) {

        this.benuterRepo = benuterRepo;
        this.passwordRepo = passwordRepo;
        this.tokenRepo = tokenRepo;
    }

    @Override
    public Boolean isBenutzerValid(String anmeldename, String password) {
        Benutzer benutzer = benuterRepo.getBenutzer(anmeldename);
        String existingPassword = passwordRepo.getPassword(benutzer.getId());
        if(existingPassword.equals(password)){
            return true;
        }
        return false;
    }

    @Override
    public String createToken() {
        return new RandomStringGenerator.Builder()
                .withinRange('0', 'z')
                .filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS)
                .build()
                .generate(12);
    }

    @Override
    public boolean isTokenGültig(String token) {
        return tokenRepo.hasToken(token);
    }

    @Override
    public void saveToken(String benutzerId, String token) {
        tokenRepo.save(benutzerId, token);
    }

    @Override
    public Benutzer getBenutzer(String anmeldename) {
        return benuterRepo.getBenutzer(anmeldename);
    }

    @Override
    public Benutzer getBenutzerFromToken(String token) {
        String userId = tokenRepo.getUserId(token);
        return benuterRepo.getBenutzerById(userId);
    }

    @Override
    public void emailUmbennen(String benutzerId, String email) {
        Benutzer existingBenutzer = benuterRepo.getBenutzerById(benutzerId);
        existingBenutzer.setEmail(email);
        benuterRepo.save(existingBenutzer);
    }

    @Override
    public void nicknameUmbennen(String benutzerId, String nickname) {
        Benutzer existingBenutzer = benuterRepo.getBenutzerById(benutzerId);
        existingBenutzer.setNickname(nickname);
        benuterRepo.save(existingBenutzer);
    }
}
