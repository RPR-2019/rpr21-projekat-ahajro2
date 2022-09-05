package com.example.plan_treninga_projekat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class SignInController {

    public TextField fldUsername;
    public PasswordField fldLozinka;
    private TrainingDAO dao = TrainingDAO.getInstance();

    @FXML
    public void initialize() {
    }

    public void onActionPrijava() throws IOException {

        Korisnik k = dao.dajKorisnika(fldUsername.getText());
        System.out.println(fldLozinka.getText());
        if(k != null && fldLozinka.getText().equals(k.getPassword())) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/trening_pocetna.fxml"));
            TreningController treningController = new TreningController(k);
            loader.setController(treningController);
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Dobrodošli u svoj plan treninga");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.show();
            stage.setResizable(false);
            Stage s = (Stage) fldUsername.getScene().getWindow();
            s.close();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Greška pri prijavi");
            alert.setHeaderText("Neispravna lozinka ili korisnicko ime");
            alert.setContentText("Pokusajte ponovo unijeti ispravne podatke!");
            alert.showAndWait();
        }
    }

    public void onActionOdustani() {

    }
}
