package com.example.plan_treninga_projekat;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class HelpController {

    public TextArea fldArea;
    @FXML
    void initialize() {
        fldArea.setText("Ono sto je bitno u ovom dokumentu jeste da se objasni kako bi se ova aplikacija trebala koristiti.\n" +
                "Ako već ovo čitate znači da ste odabrali neki od svojih planova treninga ili ste odlučili da ga pravite \n" +
                "sami. Kako bilo, bitno je objasniti kako funkcionira ova aplikacija. Ono što je najvažnije jeste da je aplikacija\n" +
                "beta verzija i da nije do kraja završena. Iznad liste koje se vide na sredini glavnog trening prozora, imamo natpise za \n" +
                "dane u sedmici, ali u isto vrijeme ti natpisi su dugmad koju mi možemo pritisnuti i dodati trening ukoliko smo izabrali da \n" +
                "pravimo svoj sopstveni plan kojeg ćemo pratiti dok napredujemo u treningu. Također, jako bitna stavka je da postoji i NAPREDNI \n" +
                "trening sto znaci da je to vec unaprijed napravljeni plan koji se ne moze korigirati zbog same opcije za pravljene vlastitgo PLANA.\n" +
                "Također, što se tiče računanja kalorija, to funkcioniše na način da je ono što dobijete kao rezultat u stvari \n" +
                "broj kalorija koji je potrebno da unesete da biste ostali na istoj kilaži i onda se po tome možete ravnati koliko unesete \n" +
                "više za debljanje (pošto je iskljucivo aplikacija namijenjena za HIPERTROFIJU MIŠIĆA - Povećanje mišićne mase) \n" +
                "Računanje bodyfat-a je u stvari samo pokazatelj u procentima koliko masti ima u vašem tijelu u odnosu na godine, kilažu etc. \n" +
                "UŽIVAJTE.");
    }
}
