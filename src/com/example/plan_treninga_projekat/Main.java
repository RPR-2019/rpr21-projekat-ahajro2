package com.example.plan_treninga_projekat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/pocetna.fxml"));
        PocetnaController pocetnaController = new PocetnaController();
        loader.setController(pocetnaController);
        Parent root = loader.load();
        stage.setTitle("Dobrodošli u APLIKACIJU ZA PLAN TRENINGA");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}