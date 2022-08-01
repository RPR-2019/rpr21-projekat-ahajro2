package com.example.plan_treninga_projekat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class OdabirController {
    public ImageView fldImageView;
    public Button btnBeginner;
    public Button btnAdvanced;
    public Button btnTop;


    @FXML
    public void initialize() {
        Image slika = new Image("/images/teretana.jpg");
        fldImageView = new ImageView();
        fldImageView.setPreserveRatio(true);
        fldImageView.setImage(slika);
        fldImageView.setFitWidth(600);
        fldImageView.setFitHeight(400);
    }

    public void actionBeginner(ActionEvent event) {

    }

    public void actionAdvanced(ActionEvent event) {

    }

    public void actionTop(ActionEvent event) {

    }


}
