package com.example.plan_treninga_projekat;


import at.mukprojects.giphy4j.Giphy;
import at.mukprojects.giphy4j.entity.giphy.GiphyData;
import at.mukprojects.giphy4j.entity.search.SearchFeed;
import at.mukprojects.giphy4j.exception.GiphyException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class PretragaController {

    public Button btnSearch;
    public FlowPane flowPane = new FlowPane();
    public Button btnOk;
    public Button btnCancel;
    public TextField fldText;

    private static final String API_KEY ="mn22EBK2mMG7CCSPGLC5NC6LPsnwmNzd";
    private static final int dimenzijaSlike = 128;
    private static final int maxBrojSlika = 25;
    private static ArrayBlockingQueue<Image> imagesBuffer;
    private static String urlSlike = null;

    public static void setUrlSlike(String url) {
        urlSlike = url;
    }
    public static String getUrlSlike() {
        return urlSlike;
    }

    @FXML
    public void initialize() {
        for(int i=0;i<maxBrojSlika;i++) {
            Button dugme = new Button();
            dugme.setPrefWidth(128);
            dugme.setPrefHeight(128);
            dugme.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Button izabranoDugme = (Button) actionEvent.getSource();
                    ImageView view = (ImageView) izabranoDugme.getGraphic();
                    Image slika = view.getImage();
                    setUrlSlike(slika.getUrl());
                }
            });
            dugme.setVisible(false);
            flowPane.getChildren().add(dugme);
        }
    }

    public void btnAction(ActionEvent actionEvent) {
        if(actionEvent.getSource() == btnOk) {
            if(getUrlSlike()==null)
                nemaSlike();
            else
                close();
        }
        else if(actionEvent.getSource() == btnCancel) {
            setUrlSlike("");
            close();
        }
        else if(actionEvent.getSource() == btnSearch){
            if(fldText.getText().isBlank())
                return;
            pokaziSlike(fldText.getText());
        }
    }

    private void sakrijDugmad() {
        for(int i=0;i<maxBrojSlika;i++) {
            flowPane.getChildren().get(i).setVisible(false);
        }
    }

    private void close() {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    private void pokaziSlike(String text) {

        sakrijDugmad();
        imagesBuffer = new ArrayBlockingQueue<>(maxBrojSlika);

        ExecutorService executor = Executors.newFixedThreadPool(2); //zbog toga sto imamo punjenje i praznjenje buffera
        //da smo definisali samo jedan thread onda bi se radilo sekvencijalno i ne bismo mogli uraditi bez stopanja i bagovanja
        //odnosno ne bi radili u isto vrijeme, zato nam i sluzi thread pool. Postoji jos jedan cachePool koliko se sjecam, on radi slicno

        executor.execute(new Thread(() -> {
            try {
                SearchFeed feed = null;
                try {
                    Giphy giphy = new Giphy(API_KEY); //povezao svoj kljuc sa Giphyem
                    feed = giphy.search(text, 25, 0);
                } catch (UnknownError e) {
                    System.out.println("Nesto nije u redu sa konekcijom");
                }
                List<String> urlovi = new ArrayList<>();
                for(GiphyData d : feed.getDataList()) {
                    String url = "https://i.giphy.com/media/" + d.getId() + "/giphy_s.gif";
                    imagesBuffer.put(new Image(url));
                    Thread.sleep(20); //da bismo pustili ucitavanje slika pomocu druge niti
                }
            }catch (GiphyException | InterruptedException p) { //interrupted exception zbog .put() metode nad bloking nizom
                p.printStackTrace();
            }
        }));

        //postavljamo na flowPane
        executor.execute(new Thread(() -> {

            ImageView view = new ImageView(new Image("/gifs/load.gif"));
            view.setFitHeight(128);
            view.setFitWidth(128);
            for(int i=0;i<maxBrojSlika;i++) {
                Button pomocnoDugme =(Button) flowPane.getChildren().get(i);
                Platform.runLater(() -> {
                    pomocnoDugme.setVisible(true); // runLater koristimo da bismo mogli promijeniti ono sto je graficki u nasem programu
                    //jer se izvrsava u posebnoj niti, a ono sto se izvrsava u grafickoj niti ne moze se promijeniti samo pomocu execute, nego
                    //moramo i .runLater navesti (Liang literatura)
                });

                Platform.runLater(() -> {
                    pomocnoDugme.setGraphic(view);
                });
                ImageView view2 = new ImageView();
                view2.setFitWidth(dimenzijaSlike);
                view2.setFitHeight(dimenzijaSlike);
                try {
                    view2.setImage(imagesBuffer.take()); //uzimamo iz bloking niza dok druga nit ceka 50 milisec
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(() -> {
                    pomocnoDugme.setGraphic(view2);
                });
            }
        }));
    }
    public void okAction(ActionEvent actionEvent) {

    }

    public static void nemaSlike() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Nijedna slika nije izabrana");
        alert.setHeaderText("Niste izabrali sliku koju želite");
        alert.setContentText("Unesite pretragu, a zatim izaberite sliku, ili kliknite na cancel");

        alert.showAndWait();
    }

}
