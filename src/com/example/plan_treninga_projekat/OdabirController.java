package com.example.plan_treninga_projekat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class OdabirController {
    public Button btnBeginner;
    public Button btnAdvanced;
    public Button btnBackground;


    @FXML
    public void initialize() {
        Image slika = new Image("/images/gym.jpg");
        Image slika1 = new Image("images/upper-lower.png");
        Image slika2 = new Image("images/full-body.png");

        ImageView imageView = new ImageView(slika);
        ImageView imageView1 = new ImageView(slika1);
        imageView1.setFitWidth(250);
        imageView1.setFitHeight(200);
        ImageView imageView2 = new ImageView(slika2);
        imageView2.setFitWidth(250);
        imageView2.setFitHeight(200);
        btnBackground.setGraphic(imageView);
        btnBeginner.setGraphic(imageView1);
        btnAdvanced.setGraphic(imageView2);
    }

    public void actionBeginner(ActionEvent event) {

    }

    public void actionAdvanced(ActionEvent event) {

    }

    public void actionTop(ActionEvent event) {

    }


}
