package com.example.plan_treninga_projekat;

import javafx.collections.ObservableList;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

import static java.sql.Types.NULL;

public class TrainingDAO {

    private static TrainingDAO instance = null;
    private Connection conn;

    private PreparedStatement brojRedova, dodajRedove, dodajKorisnika, prviUpit, dodajVjezbuPon, dodajRedPon,
            dodajVjezbuUto, dodajVjezbuSri, dodajVjezbuCet, dodajVjezbuPet, dodajVjezbuSub, dodajVjezbuNed, dajIdKorisnikaUpit, dajKorisnikaUpit,
            dajVjezbePon, dajVjezbeUto, dajVjezbeSri, dajVjezbeCet, dajVjezbePet, dajVjezbeSub, dajVjezbeNed;

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
            dodajVjezbuUto = conn.prepareStatement("INSERT INTO utorak VALUES(?, ?)");
            dodajVjezbuSri = conn.prepareStatement("INSERT INTO srijeda VALUES(?, ?)");
            dodajVjezbuCet = conn.prepareStatement("INSERT INTO cetvrtak VALUES(?, ?)");
            dodajVjezbuPet = conn.prepareStatement("INSERT INTO petak VALUES(?, ?)");
            dodajVjezbuSub = conn.prepareStatement("INSERT INTO subota VALUES(?, ?)");
            dodajVjezbuNed = conn.prepareStatement("INSERT INTO nedjelja VALUES(?, ?)");

            dajVjezbePon = conn.prepareStatement("SELECT pon FROM ponedjeljak WHERE id = ?");
            dajVjezbeUto = conn.prepareStatement("SELECT uto FROM utorak WHERE id = ?");
            dajVjezbeSri = conn.prepareStatement("SELECT sri FROM srijeda WHERE id = ?");
            dajVjezbeCet = conn.prepareStatement("SELECT cet FROM cetvrtak WHERE id = ?");
            dajVjezbePet = conn.prepareStatement("SELECT pet FROM petak WHERE id = ?");
            dajVjezbeSub = conn.prepareStatement("SELECT sub FROM subota WHERE id = ?");
            dajVjezbeNed = conn.prepareStatement("SELECT ned FROM nedjelja WHERE id = ?");


            brojRedova = conn.prepareStatement("SELECT MAX(id)+1 FROM korisnik");
            dajIdKorisnikaUpit = conn.prepareStatement("SELECT id FROM korisnik WHERE username = ?");

            dajKorisnikaUpit = conn.prepareStatement("SELECT * FROM korisnik WHERE username=?");
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

    public void setDodajVjezbuUto(int id, String vjezba) {
        try {
            dodajVjezbuUto.setInt(1, id);
            dodajVjezbuUto.setString(2, vjezba);
            dodajVjezbuUto.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setDodajVjezbuSri(int id, String vjezba) {
        try {
            dodajVjezbuSri.setInt(1, id);
            dodajVjezbuSri.setString(2, vjezba);
            dodajVjezbuSri.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setDodajVjezbuCet(int id, String vjezba) {
        try {
            dodajVjezbuCet.setInt(1, id);
            dodajVjezbuCet.setString(2, vjezba);
            dodajVjezbuCet.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setDodajVjezbuPet(int id, String vjezba) {
        try {
            dodajVjezbuPet.setInt(1, id);
            dodajVjezbuPet.setString(2, vjezba);
            dodajVjezbuPet.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setDodajVjezbuSub(int id, String vjezba) {
        try {
            dodajVjezbuSub.setInt(1, id);
            dodajVjezbuSub.setString(2, vjezba);
            dodajVjezbuSub.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setDodajVjezbuNed(int id, String vjezba) {
        try {
            dodajVjezbuNed.setInt(1, id);
            dodajVjezbuNed.setString(2, vjezba);
            dodajVjezbuNed.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<String> dajVjezbeZaIdKorisnikaPon(int id) {

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

    public Korisnik dajKorisnika(String username) {
        try {
            dajKorisnikaUpit.setString(1, username);
            ResultSet rs = dajKorisnikaUpit.executeQuery();
            if(rs.next()) {
                System.out.println(rs.getString(6));
                Korisnik k = new Korisnik(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                       rs.getString(5), rs.getString(6), rs.getString(7),
                       rs.getString(8), rs.getString(9));

               return k;
            }
            else return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
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
