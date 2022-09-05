package com.example.plan_treninga_projekat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;


public class TreningController {
    public Button btnPon;
    public Button btnUto;
    public Button btnSri;
    public Button btnCet;
    public Button btnPet;
    public Button btnSub;
    public Button btnNed;
    public Button buttonCal;
    public Button buttonFat;
    public Button buttonSup;
    public Button buttonExpl;
    public Button btnSlika;

    public ListView lvPon;
    public ListView lvUto;
    public ListView lvSri;
    public ListView lvCet;
    public ListView lvPet;
    public ListView lvSub;
    public ListView lvNed;

    private Korisnik korisnik;
    private TrainingDAO dao = TrainingDAO.getInstance();
    private ObservableList<String> listaVjezbi = FXCollections.observableArrayList();



    public TreningController(Korisnik k) {
        korisnik = new Korisnik(k);
    }

    @FXML
    public void initialize() {


    }

    public void onActionSlikaT() {

    }

    public void onActionSuplementation() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/suplementacija.fxml"));
        SuplementationController suplementationController = new SuplementationController();
        loader.setController(suplementationController);
        Parent root = loader.load();
        stage.setTitle("Informacije o suplementaciji");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(true);
        stage.show();
    }

    public void onActionExplonation() {

    }

    public void onActionCalculateCal() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/kalorije.fxml"));
        CalorieController calorieController = new CalorieController();
        loader.setController(calorieController);
        Parent root = loader.load();
        stage.setTitle("Kalkulator za računanje kalorija");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(true);
        stage.show();
    }

    public void onActionCalculateFat() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/bodyfat.fxml"));
        FatController fatController = new FatController();
        loader.setController(fatController);
        Parent root = loader.load();
        stage.setTitle("Kalkulator za računanje BodyFat-a");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(true);
        stage.show();
    }

    public void onActionPonedjeljak() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodavanje_vjezbi.fxml"));
        ExerciseController exerciseController = new ExerciseController();
        loader.setController(exerciseController);
        Parent root = loader.load();
        stage.setTitle("Prozor za dodavanje vježbi");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(true);
        stage.show();
        stage.setOnHiding(event -> {
            if(!exerciseController.getFldVjezba().trim().equals("")) {
                System.out.println(exerciseController.getFldVjezba());
                dao.setDodajVjezbuPon(korisnik.getId(), exerciseController.getFldVjezba());
                listaVjezbi.add(exerciseController.getFldVjezba());
                lvPon.setItems(listaVjezbi);
            }
        });
    }
    public void onActionUtorak() {

    }
    public void onActionSrijeda() {

    }
    public void onActionCetvrtak() {

    }
    public void onActionPetak() {

    }
    public void onActionSubota() {

    }
    public void onActionNedjelja() {

    }


}
