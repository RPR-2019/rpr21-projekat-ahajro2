package com.example.plan_treninga_projekat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

import static java.sql.Types.NULL;

public class TrainingDAO {

    private static TrainingDAO instance = null;
    private Connection conn;

    private PreparedStatement brojRedova, dodajRedove, dodajKorisnika, prviUpit, dodajVjezbuPon, dodajRedPon,
            dodajVjezbuUto, dodajVjezbuSri, dodajVjezbuCet, dodajVjezbuPet, dodajVjezbuSub, dodajVjezbuNed, dajIdKorisnikaUpit;

    private TrainingDAO() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:baza.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            prviUpit = conn.prepareStatement("SELECT * FROM korisnik");
        } catch (SQLException throwables) {
            regenerisiBazu();
            try {
                prviUpit = conn.prepareStatement("SELECT * FROM korisnik");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            dodajKorisnika = conn.prepareStatement("INSERT INTO korisnik VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            dodajVjezbuPon = conn.prepareStatement("INSERT INTO ponedjeljak VALUES(?, ?)");
            brojRedova = conn.prepareStatement("SELECT MAX(id)+1 FROM korisnik");
            dajIdKorisnikaUpit = conn.prepareStatement("SELECT id FROM korisnik WHERE username = ?");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void regenerisiBazu() {
        Scanner ulaz = null;
        try {
            ulaz = new Scanner(new FileInputStream("baza.db.sql"));
            String sqlUpit = "";
            while (ulaz.hasNext()) {
                sqlUpit += ulaz.nextLine();
                if ( sqlUpit.charAt( sqlUpit.length()-1 ) == ';') {
                    try {
                        Statement stmt = conn.createStatement();
                        stmt.execute(sqlUpit);
                        sqlUpit = "";
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            ulaz.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void removeInstance() {
        if (instance == null) return;
        instance.close();
        instance = null;
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dodajKorisnika(Korisnik k) {
        try {
            ResultSet rs = brojRedova.executeQuery();
            int id = 1;
            if(rs.next()) {
                id = rs.getInt(1);
                System.out.println(id);
            }
            dodajKorisnika.setInt(1, id);
            dodajKorisnika.setString(2, k.getIme());
            dodajKorisnika.setString(3, k.getPrezime());
            dodajKorisnika.setString(4, k.getEmail());
            dodajKorisnika.setString(5, k.getUsername());
            dodajKorisnika.setString(6, k.getPassword());
            dodajKorisnika.setString(7, k.getVisina());
            dodajKorisnika.setString(8, k.getTezina());
            dodajKorisnika.setString(9, k.getOpcija().toString());
            dodajKorisnika.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void setDodajVjezbuPon(int id, String vjezba) {
        try {
            dodajVjezbuPon.setInt(1, id);
            dodajVjezbuPon.setString(2, vjezba);
            dodajVjezbuPon.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int dajIdKorisnika(String username) {
        try {
            dajIdKorisnikaUpit.setString(1, username);
            ResultSet rs = dajIdKorisnikaUpit.executeQuery();
            int id = 0;
            if(rs.next()) {
                id = rs.getInt(1);
            }
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void dodajVjezbu(Korisnik k, String dan, String vjezba) {
        try {
            dodajVjezbuPon.setString(1,vjezba);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static TrainingDAO getInstance() {
        if(instance == null) instance = new TrainingDAO();
        return instance;
    }
}
