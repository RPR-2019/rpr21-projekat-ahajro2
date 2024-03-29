package com.example.plan_treninga_projekat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class PocetnaController {

    public Button buttonSlika = new Button();
    public Button buttonSignIn = new Button();
    public Button buttonSignUp = new Button();
    public TrainingDAO dao = TrainingDAO.getInstance();


    public PocetnaController() {

    }

    @FXML
    void initialize() {
        Image slika = new Image("/images/pocetna.jpg");
        ImageView imageView= new ImageView(slika);
        imageView.setFitHeight(245);
        imageView.setFitWidth (400);
        buttonSlika.setGraphic(imageView);
        buttonSignIn.setStyle("-fx-background-color: #00ff00");
        buttonSignUp.setStyle("-fx-background-color: #808080");
    }

    public void actionSignUp() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/signUp.fxml"));
        SignUpController signUpController = new SignUpController(new KorisniciModel());
        loader.setController(signUpController);
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Registruj se");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(true);
        stage.show();
    }

    public void actionSignIn() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/signIn.fxml"));
        SignInController signInController = new SignInController();
        loader.setController(signInController);
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Prijavi se na svoj trening plan");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();
    }
}