package com.example.plan_treninga_projekat;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class SuplementationController {
    public TextArea fldKreatin;
    public TextArea fldKofein;
    public TextArea fldWhey;

    @FXML
    public void initialize() {
        fldKofein.setText("Kofein je jedan od najboljih i najkorištenijih suplemenata za kojeg vjerovatno niste culi" +
                "u duhu treniranja, ali je jako pogodan i pospješuje performans kako rekreativaca, tako i ozbiljnih" +
                "vježbača. Ono što je interesantno da nije potreban nikakav preworkout kako bi nas trening bio efikasan vec je sasvim dovoljna" +
                "jedna šoljica kafe koja će nam dati dodatnu snagu na treningu, a usput i domaća kafa je zdrava da se nekada popije :D");
        fldKreatin.setText("Kreatin je jedan on najistraživanijih suplemenata koji kao i kofein daje dosta dobre benefite onome ko trenira. " +
                "Postoje 2 načina kako uzimati kreatin, a to je faza punjenja koja traje 7 dana i uzima se po 20g, a isto tako postoji faza" +
                "koja traje vremenski period koji treniramo, a to je da uzimamo od 3 do 5 grama kreatina svakog dana bez obzira da li treniramo" +
                "ili ne. Ovo je zaista suplement koji daje rezultate i dodaje nam koji procenat više vode u tijelo, tj. mišiće što pospješuje" +
                "dobijanje mišićne mase.");
        fldWhey.setText("Mislim da je ovo suplement za kojeg su svi čuli. Suplement koji olakšava život poslije treninga onome ko želi do " +
                "mišićne mase. Svakako, ovaj, kao i svaki drugi suplement nisu zamjena za kvalitetnu prehranu, ali ukoliko nam je muka ovaj " +
                "sirutkin protein koji u sebi ima otprilike od 21 do 25 grama proteina u 30 grama praha, znači da će dosta dobro zamijeniti taj" +
                "obrok poslije treninga dok ne dobijemo apetit za pojesti nešto konkretno!");
    }
}
