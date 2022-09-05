package com.example.plan_treninga_projekat;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ExerciseController {
    public TextField fldVjezba;
    public Button btnDodaj;

    @FXML
    void initialize() {

    }

    public String getFldVjezba() {
        return fldVjezba.getText();
    }

    public void dodajVjezbu() {
        Stage stage = (Stage) fldVjezba.getScene().getWindow();
        stage.close();
    }
}
