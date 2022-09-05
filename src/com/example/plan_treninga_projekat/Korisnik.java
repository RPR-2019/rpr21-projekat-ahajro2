package com.example.plan_treninga_projekat;

import javafx.beans.property.SimpleStringProperty;

public class Korisnik {
    private int id;
    private String ime, prezime, email, username, password, visina, tezina;
    public enum OpcijeTreninga {
        POCETNIK,
        NAPREDNI,
        MOJ_PLAN
    }
    OpcijeTreninga opcija;
    private String url;

    public Korisnik() {

    }

    public Korisnik(Korisnik k) {
        id = k.id;
        ime = k.ime;
        prezime = k.prezime;
        email = k.email;
        username = k.username;
        password = k.password;
        visina = k.visina;
        tezina = k.tezina;
        opcija = k.opcija;
    }

    public Korisnik(String ime, String prezime, String email, String username, String password, String visina, String tezina, String opcijeTreninga) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.username = username;
        this.password = password;
        this.visina = visina;
        this.tezina = tezina;
        if(opcijeTreninga.equals("POCETNIK")) {
            opcija = OpcijeTreninga.POCETNIK;
        } else if(opcijeTreninga.equals("NAPREDNI")) {
            opcija = OpcijeTreninga.NAPREDNI;
        } else if(opcijeTreninga.equals("MOJ_PLAN")) {
            opcija = OpcijeTreninga.MOJ_PLAN;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVisina() {
        return visina;
    }

    public void setVisina(String visina) {
        this.visina = visina;
    }

    public String getTezina() {
        return tezina;
    }

    public void setTezina(String tezina) {
        this.tezina = tezina;
    }

    public OpcijeTreninga getOpcija() {
        return opcija;
    }

    public void setOpcija(OpcijeTreninga opcija) {
        this.opcija = opcija;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
