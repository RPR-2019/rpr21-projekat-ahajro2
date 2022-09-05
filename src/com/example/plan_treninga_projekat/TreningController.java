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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private ObservableList<String> listaVjezbiPon = FXCollections.observableArrayList();
    private ObservableList<String> listaVjezbiUto = FXCollections.observableArrayList();
    private ObservableList<String> listaVjezbiSri = FXCollections.observableArrayList();
    private ObservableList<String> listaVjezbiCet = FXCollections.observableArrayList();
    private ObservableList<String> listaVjezbiPet = FXCollections.observableArrayList();
    private ObservableList<String> listaVjezbiSub = FXCollections.observableArrayList();
    private ObservableList<String> listaVjezbiNed = FXCollections.observableArrayList();




    public TreningController(Korisnik k) {
        korisnik = new Korisnik(k);
    }

    @FXML
    public void initialize() {

        if(korisnik.getOpcija() == Korisnik.OpcijeTreninga.MOJ_PLAN || korisnik.getOpcija() == Korisnik.OpcijeTreninga.POCETNIK ) {
            listaVjezbiPon.addAll(dao.dajVjezbeZaIdKorisnikaPon(korisnik.getId()));
            lvPon.setItems(listaVjezbiPon);
            System.out.println(listaVjezbiPon.size());
            listaVjezbiUto.addAll(dao.dajVjezbeZaIdKorisnikaUto(korisnik.getId()));
            lvUto.setItems(listaVjezbiUto);
            listaVjezbiSri.addAll(dao.dajVjezbeZaIdKorisnikaSri(korisnik.getId()));
            lvSri.setItems(listaVjezbiSri);
            listaVjezbiCet.addAll(dao.dajVjezbeZaIdKorisnikaCet(korisnik.getId()));
            lvCet.setItems(listaVjezbiCet);
            listaVjezbiPet.addAll(dao.dajVjezbeZaIdKorisnikaPet(korisnik.getId()));
            lvPet.setItems(listaVjezbiPet);
            listaVjezbiSub.addAll(dao.dajVjezbeZaIdKorisnikaSub(korisnik.getId()));
            lvSub.setItems(listaVjezbiSub);
            listaVjezbiNed.addAll(dao.dajVjezbeZaIdKorisnikaNed(korisnik.getId()));
            lvNed.setItems(listaVjezbiNed);
        }
        else if(korisnik.getOpcija() == Korisnik.OpcijeTreninga.NAPREDNI) {
            listaVjezbiPon.addAll(dao.dajVjezbeKorisnikaPonNapredni());
            lvPon.setItems(listaVjezbiPon);
            System.out.println(listaVjezbiPon.size());
            listaVjezbiUto.addAll(dao.dajVjezbeKorisnikaUtoNapredni());
            lvUto.setItems(listaVjezbiUto);
            listaVjezbiSri.addAll(dao.dajVjezbeKorisnikaSriNapredni());
            lvSri.setItems(listaVjezbiSri);
            listaVjezbiCet.addAll(dao.dajVjezbeKorisnikaCetNapredni());
            lvCet.setItems(listaVjezbiCet);
            listaVjezbiPet.addAll(dao.dajVjezbeKorisnikaPetNapredni());
            lvPet.setItems(listaVjezbiPet);
            listaVjezbiSub.addAll(dao.dajVjezbeKorisnikaSubNapredni());
            lvSub.setItems(listaVjezbiSub);
            listaVjezbiNed.addAll(dao.dajVjezbeKorisnikaNedNapredni());
            lvNed.setItems(listaVjezbiNed);
        }
        ImageView view = new ImageView();
        view.setFitWidth(128);
        view.setFitHeight(128);
        view.setImage(new Image(korisnik.getUrl()));
        btnSlika.setGraphic(view);

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
        stage.setResizable(false);
        stage.show();
    }

    public void onActionExplonation() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/pojmovi.fxml"));
        HelpController helpController = new HelpController();
        loader.setController(helpController);
        Parent root = loader.load();
        stage.setTitle("Objašnjenje korištenja aplikacije");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();
    }

    public void onActionCalculateCal() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/kalorije.fxml"));
        CalorieController calorieController = new CalorieController();
        loader.setController(calorieController);
        Parent root = loader.load();
        stage.setTitle("Kalkulator za računanje kalorija");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
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
        stage.setResizable(false);
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
        stage.setResizable(false);
        stage.show();
        stage.setOnHiding(event -> {
            if(!exerciseController.getFldVjezba().trim().equals("")) {
                System.out.println(exerciseController.getFldVjezba());
                dao.setDodajVjezbuPon(korisnik.getId(), exerciseController.getFldVjezba());
                listaVjezbiPon.add(exerciseController.getFldVjezba());
                lvPon.setItems(listaVjezbiPon);
            }
        });
    }
    public void onActionUtorak() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodavanje_vjezbi.fxml"));
        ExerciseController exerciseController = new ExerciseController();
        loader.setController(exerciseController);
        Parent root = loader.load();
        stage.setTitle("Prozor za dodavanje vježbi");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();
        stage.setOnHiding(event -> {
            if(!exerciseController.getFldVjezba().trim().equals("")) {
                System.out.println(exerciseController.getFldVjezba());
                dao.setDodajVjezbuUto(korisnik.getId(), exerciseController.getFldVjezba());
                listaVjezbiUto.add(exerciseController.getFldVjezba());
                lvUto.setItems(listaVjezbiUto);
            }
        });
    }
    public void onActionSrijeda() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodavanje_vjezbi.fxml"));
        ExerciseController exerciseController = new ExerciseController();
        loader.setController(exerciseController);
        Parent root = loader.load();
        stage.setTitle("Prozor za dodavanje vježbi");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();
        stage.setOnHiding(event -> {
            if(!exerciseController.getFldVjezba().trim().equals("")) {
                System.out.println(exerciseController.getFldVjezba());
                dao.setDodajVjezbuSri(korisnik.getId(), exerciseController.getFldVjezba());
                listaVjezbiSri.add(exerciseController.getFldVjezba());
                lvSri.setItems(listaVjezbiSri);
            }
        });
    }
    public void onActionCetvrtak() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodavanje_vjezbi.fxml"));
        ExerciseController exerciseController = new ExerciseController();
        loader.setController(exerciseController);
        Parent root = loader.load();
        stage.setTitle("Prozor za dodavanje vježbi");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();
        stage.setOnHiding(event -> {
            if(!exerciseController.getFldVjezba().trim().equals("")) {
                System.out.println(exerciseController.getFldVjezba());
                dao.setDodajVjezbuCet(korisnik.getId(), exerciseController.getFldVjezba());
                listaVjezbiCet.add(exerciseController.getFldVjezba());
                lvCet.setItems(listaVjezbiCet);
            }
        });
    }
    public void onActionPetak() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodavanje_vjezbi.fxml"));
        ExerciseController exerciseController = new ExerciseController();
        loader.setController(exerciseController);
        Parent root = loader.load();
        stage.setTitle("Prozor za dodavanje vježbi");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();
        stage.setOnHiding(event -> {
            if(!exerciseController.getFldVjezba().trim().equals("")) {
                System.out.println(exerciseController.getFldVjezba());
                dao.setDodajVjezbuPet(korisnik.getId(), exerciseController.getFldVjezba());
                listaVjezbiPet.add(exerciseController.getFldVjezba());
                lvPet.setItems(listaVjezbiPet);
            }
        });
    }
    public void onActionSubota() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodavanje_vjezbi.fxml"));
        ExerciseController exerciseController = new ExerciseController();
        loader.setController(exerciseController);
        Parent root = loader.load();
        stage.setTitle("Prozor za dodavanje vježbi");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();
        stage.setOnHiding(event -> {
            if(!exerciseController.getFldVjezba().trim().equals("")) {
                System.out.println(exerciseController.getFldVjezba());
                dao.setDodajVjezbuSub(korisnik.getId(), exerciseController.getFldVjezba());
                listaVjezbiSub.add(exerciseController.getFldVjezba());
                lvSub.setItems(listaVjezbiSub);
            }
        });
    }
    public void onActionNedjelja() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodavanje_vjezbi.fxml"));
        ExerciseController exerciseController = new ExerciseController();
        loader.setController(exerciseController);
        Parent root = loader.load();
        stage.setTitle("Prozor za dodavanje vježbi");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();
        stage.setOnHiding(event -> {
            if(!exerciseController.getFldVjezba().trim().equals("")) {
                System.out.println(exerciseController.getFldVjezba());
                dao.setDodajVjezbuNed(korisnik.getId(), exerciseController.getFldVjezba());
                listaVjezbiNed.add(exerciseController.getFldVjezba());
                lvNed.setItems(listaVjezbiNed);
            }
        });
    }

    public void onActionAboutMenu() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/pojmovi.fxml"));
        HelpController helpController = new HelpController();
        loader.setController(helpController);
        Parent root = loader.load();
        stage.setTitle("Objašnjenje korištenja aplikacije");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();
    }

    public void onActionCloseMenu() {
        Stage s = (Stage) btnSlika.getScene().getWindow();
        s.close();
    }


}
