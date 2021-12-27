package com.wanzl.aufgabe;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter @Getter
public class Benutzer {

    private String Id;
    private String Email;
    private String Nickname;
    private Date Registrierungsdatum;
    private Date LetzteAnmeldung;
    private Date LetzteAktualisierung;

    public Benutzer(String email) {
        this.Email = email;
    }

    @Override
    public String toString() {
        return "Benutzer{" +
                "Id='" + Id + '\'' +
                ", Email='" + Email + '\'' +
                ", Nickname='" + Nickname + '\'' +
                ", Registrierungsdatum=" + Registrierungsdatum +
                ", LetzteAnmeldung=" + LetzteAnmeldung +
                ", LetzteAktualisierung=" + LetzteAktualisierung +
                '}';
    }
}
