package com.example.plan_treninga_projekat;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
import static javafx.scene.layout.Region.USE_PREF_SIZE;

public class SignUpController {
    public TextField fldIme;
    public TextField fldPrezime;
    public TextField fldEmail;
    public TextField fldUsername;
    public TextField fldTezina;
    public TextField fldVisina;
    public PasswordField fldPassword;
    public Button imgKorisnik;
    public TextArea fldArea;
    private KorisniciModel model;

    public SignUpController(KorisniciModel model) {
        this.model = model;
    }

    @FXML
    public void initialize() {
//        listKorisnici.setItems(model.getKorisnici());
        ImageView view = new ImageView();
        view.setFitHeight(128);
        view.setFitWidth(128);
        fldArea.setText("""
                TOP QUOTES FOR SUCCESS FROM GIANTS\s
                1. ‘The last three or four reps is what makes the muscle grow. This area of pain divides a champion from someone who is not a champion.’

                — Arnold Schwarzenegger, seven-time Mr. Olympia

                2. ‘Success usually comes to those who are too busy to be looking for it.’

                — Henry David Thoreau, poet and philosopher

                3. ‘All progress takes place outside the comfort zone.’

                — Michael John Bobak, digital artist

                4. ‘If you think lifting is dangerous, try being weak. Being weak is dangerous.’

                — Bret Contreras, sports scientist

                5. ‘The only place where success comes before work is in the dictionary.’

                — Vidal Sassoon, hairstylist and businessman

                6. ‘The clock is ticking. Are you becoming the person you want to be?’

                — Greg Plitt, fitness model
                """);


//        model.trenutniKorisnikProperty().addListener((obs, oldKorisnik, newKorisnik) -> {
//            for(Korisnik k : model.getKorisnici()) {
//                model.izmijeni(k, k.getId());
//            }
//
//            if(newKorisnik.getUrl()!=null && newKorisnik.getUrl()!=""){
//                view.setImage(new Image(newKorisnik.getUrl()));
//                imgKorisnik.setGraphic(view);
//            }
//            else {
//                view.setImage(new Image("/img/face-smile.png"));
//                imgKorisnik.setGraphic(view);
//            }
//            if (oldKorisnik != null) {
//                fldIme.textProperty().unbindBidirectional(oldKorisnik.imeProperty());
//                fldPrezime.textProperty().unbindBidirectional(oldKorisnik.prezimeProperty() );
//                fldEmail.textProperty().unbindBidirectional(oldKorisnik.emailProperty() );
//                fldUsername.textProperty().unbindBidirectional(oldKorisnik.usernameProperty() );
//                fldPassword.textProperty().unbindBidirectional(oldKorisnik.passwordProperty() );
//            }
//            if (newKorisnik == null) {
//                fldIme.setText("");
//                fldPrezime.setText("");
//                fldEmail.setText("");
//                fldUsername.setText("");
//                fldPassword.setText("");
//            }
//            else {
//                fldIme.textProperty().bindBidirectional( newKorisnik.imeProperty() );
//                fldPrezime.textProperty().bindBidirectional( newKorisnik.prezimeProperty() );
//                fldEmail.textProperty().bindBidirectional( newKorisnik.emailProperty() );
//                fldUsername.textProperty().bindBidirectional( newKorisnik.usernameProperty() );
//                fldPassword.textProperty().bindBidirectional( newKorisnik.passwordProperty() );
//            }
//        });
//
        fldIme.textProperty().addListener((obs, oldIme, newIme) -> {
            if (!newIme.isEmpty()) {
                fldIme.getStyleClass().removeAll("poljeNijeIspravno");
                fldIme.getStyleClass().add("poljeIspravno");
            } else {
                fldIme.getStyleClass().removeAll("poljeIspravno");
                fldIme.getStyleClass().add("poljeNijeIspravno");
            }
        });

        fldPrezime.textProperty().addListener((obs, oldIme, newIme) -> {
            if (!newIme.isEmpty()) {
                fldPrezime.getStyleClass().removeAll("poljeNijeIspravno");
                fldPrezime.getStyleClass().add("poljeIspravno");
            } else {
                fldPrezime.getStyleClass().removeAll("poljeIspravno");
                fldPrezime.getStyleClass().add("poljeNijeIspravno");
            }
        });

        fldEmail.textProperty().addListener((obs, oldIme, newIme) -> {
            if (!newIme.isEmpty()) {
                fldEmail.getStyleClass().removeAll("poljeNijeIspravno");
                fldEmail.getStyleClass().add("poljeIspravno");
            } else {
                fldEmail.getStyleClass().removeAll("poljeIspravno");
                fldEmail.getStyleClass().add("poljeNijeIspravno");
            }
        });

        fldUsername.textProperty().addListener((obs, oldIme, newIme) -> {
            if (!newIme.isEmpty()) {
                fldUsername.getStyleClass().removeAll("poljeNijeIspravno");
                fldUsername.getStyleClass().add("poljeIspravno");
            } else {
                fldUsername.getStyleClass().removeAll("poljeIspravno");
                fldUsername.getStyleClass().add("poljeNijeIspravno");
            }
        });

        fldPassword.textProperty().addListener((obs, oldIme, newIme) -> {
            if (!newIme.isEmpty() && fldPassword.getText().length() >= 6) {
                fldPassword.getStyleClass().removeAll("poljeNijeIspravno");
                fldPassword.getStyleClass().add("poljeIspravno");
            } else {
                fldPassword.getStyleClass().removeAll("poljeIspravno");
                fldPassword.getStyleClass().add("poljeNijeIspravno");
            }
        });

        fldVisina.textProperty().addListener((obs, oldVisina, newVisina) -> {
            if(!newVisina.isEmpty()) {
                fldVisina.getStyleClass().removeAll("poljeNijeIspravno");
                fldVisina.getStyleClass().add("poljeIspravno");
            }
            else {
                fldVisina.getStyleClass().removeAll("poljeIspravno");
                fldVisina.getStyleClass().add("poljeNijeIspravno");
            }
        });

        fldTezina.textProperty().addListener((obs, oldTezina, newTezina) -> {
            if(!newTezina.isEmpty()) {
                fldTezina.getStyleClass().removeAll("poljeNijeIspravno");
                fldTezina.getStyleClass().add("poljeIspravno");
            }
            else {
                fldTezina.getStyleClass().removeAll("poljeIspravno");
                fldTezina.getStyleClass().add("poljeNijeIspravno");
            }
        });
    }

    public void registrujAction(ActionEvent actionEvent) throws IOException {
        if(fldPassword.getText().length() < 6) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greška pri registraciji");
            alert.setHeaderText("Neispravna lozinka");
            alert.setContentText("Lozinka mora imati najmanje 6 znakova!");
            alert.showAndWait();
        }
        else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/prva_pocetna.fxml"));
            OdabirController odabirController = new OdabirController();
            loader.setController(odabirController);
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Dobrodošli u trening IZBORNIK");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.show();
        }
    }

    public void odustaniAction(ActionEvent actionEvent) { //skontati kada i gdje dodati metodu za dodavanje u bazu
//        listKorisnici.refresh();
//        int id = 1;
//        for(Korisnik k : listKorisnici.getItems()) {
//            model.izmijeni(k, id);
//            id++;
//        }
//        System.exit(0);
    }



    public void aboutAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/novi.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();
    }

    public void slikaAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/pretraga.fxml"));
        Parent root = loader.load();
        PretragaController noviProzor = loader.getController();
        stage.setTitle("Pretrazivanje gifa");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(true);
        stage.show();
//        imgKorisnik.setPrefWidth(128);
//        imgKorisnik.setPrefHeight(128);
//        noviProzor.btnOk.getScene().getWindow().setOnHiding(e -> {
//            model.postaviSliku(model.getTrenutniKorisnik(), PretragaController.getUrlSlike());
//            model.getTrenutniKorisnik().setUrl(PretragaController.getUrlSlike());
//            if(PretragaController.getUrlSlike()!=null && PretragaController.getUrlSlike()!="") {
//                ImageView view = new ImageView();
//                view.setFitWidth(128);
//                view.setFitHeight(128);
//                view.setImage(new Image(PretragaController.getUrlSlike()));
//                imgKorisnik.setGraphic(view);}
//        });

    }
    public void exitAction(ActionEvent actionEvent) {
        Stage st = (Stage) fldPrezime.getScene().getWindow();
        st.close();
    }
}

