package com.example.plan_treninga_projekat;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class FatController {

    public TextField fldTezina;
    public TextField fldVisina;
    public TextField fldGodine;
    public TextField fldRezultat;
    public TextField fldObimStruka;
    public TextField fldObimVrata;

    @FXML
    public void initialize() {

    }

    public void onActionIzracunajFat() {
        int tezina = Integer.parseInt(fldTezina.getText());
        double visina = Integer.parseInt(fldVisina.getText());
        int godine = Integer.parseInt(fldGodine.getText());
        int obimVrata = Integer.parseInt(fldObimVrata.getText());
        int obimStruka = Integer.parseInt(fldObimStruka.getText());
        visina = visina/100;


        double BMI = tezina/(visina*visina);
        double bodyFat = (1.39 * BMI) + (0.16 * godine) - (10.34 * 1) - 9;
        fldRezultat.setText(String.valueOf(bodyFat) + '%');
    }
}
