package com.wanzl.aufgabe.factories;

import com.wanzl.aufgabe.repositories.*;

import java.util.HashMap;
import java.util.Map;

public class RepoFactory {
    public static final String BENUTZER_REPO = "benutzerRepo";
    public static final String PASSWORD_REPO = "passwordRepo";
    public static final String TOKEN_REPO = "tokenRepo";
    private static Map<String, Object> singletonRepos = new HashMap();

    public static final BenutzerRepo getBenuterRepo(){
        if(singletonRepos.get(BENUTZER_REPO) == null) {
            singletonRepos.put(BENUTZER_REPO, new InMemoryBenutzerRepo());
        }
        return (BenutzerRepo) singletonRepos.get(BENUTZER_REPO);
    }

    public static PasswordRepo getPasswordRepo() {
        if(singletonRepos.get(PASSWORD_REPO) == null) {
            singletonRepos.put(PASSWORD_REPO, new InMemoryPasswordRepo());
        }
        return (PasswordRepo) singletonRepos.get(PASSWORD_REPO);
    }

    public static TokenRepo getTokenRepo() {
        if(singletonRepos.get(TOKEN_REPO) == null){
            singletonRepos.put(TOKEN_REPO, new InMemoryTokenRepo());
        }
        return (TokenRepo) singletonRepos.get(TOKEN_REPO);
    }
}
