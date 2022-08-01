package com.example.plan_treninga_projekat;

import javafx.beans.property.SimpleObjectProperty;

public class KorisniciModel {
    public SimpleObjectProperty<Korisnik> trenutniKorisnik = new SimpleObjectProperty<>();

    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik.get();
    }

    public SimpleObjectProperty<Korisnik> trenutniKorisnikProperty() {
        return trenutniKorisnik;
    }

    public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        this.trenutniKorisnik.set(trenutniKorisnik);
    }
}
