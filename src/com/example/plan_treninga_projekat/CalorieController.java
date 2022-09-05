package com.example.plan_treninga_projekat;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CalorieController {

    public TextField fldTezina;
    public TextField fldVisina;
    public TextField fldGodine;
    public TextField fldRezultat;


    @FXML
    public void initialize() {

    }



    public void onActionIzracunajKalorije() {
        if(fldTezina.getText().isBlank() || fldGodine.getText().isBlank() || fldVisina.getText().isBlank()) {
            fldTezina.getStyleClass().removeAll(".poljeIspravno");
            fldTezina.getStyleClass().addAll(".poljeNeispravno");

            //napisati jos za dva polja
        }
        int tezina = Integer.parseInt(fldTezina.getText());
        int visina = Integer.parseInt(fldVisina.getText());
        int godine = Integer.parseInt(fldGodine.getText());

        double kalorije = 66.47 + (13.75 * tezina) + (5.003 * visina) - (6.755 * godine);
        fldRezultat.setText(String.valueOf(kalorije));
    }
}
