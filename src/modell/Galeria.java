package modell;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Galeria implements Iterable<KiallitasiTargy>{

    private ArrayList<KiallitasiTargy> targyak;

    public Galeria() {
        targyak = new ArrayList<>();
        try {
            //készítő és cím
            Festmeny f1 = new Festmeny("cim1", "keszito3");
            //készítő és cím a mai dátummal
            Festmeny f2 = new Festmeny(LocalDate.now(), "cim2", "keszito4");
            //készítő és cím a hibás dátummal
            //Festmeny f3 = new Festmeny(LocalDate.parse("2023-01-14"), "cim5", "keszito2");
            //készítő és cím fájl eléréssel
            Festmeny f4 = new Festmeny(new File("kep.txt"), "cim4", "keszito1");
            //készítő és cím fájl eléréssel, mai dátummal
            Festmeny f5 = new Festmeny(new File("kep.txt"), LocalDate.now(), "cim3", "keszito5");
            targyak.add(f1);
            targyak.add(f2);
            //targyak.add(f3);
            targyak.add(f4);
            targyak.add(f5);

        } catch (HibasDatumException ex) {
            Logger.getLogger(Galeria.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void felvesz(KiallitasiTargy targy){
        targyak.add(targy);
    }

    public List<KiallitasiTargy> rendezCimSzerint() {
        Collections.sort(targyak, KiallitasiTargy.cimRendez());
        return Collections.unmodifiableList(targyak);
    }

    public List<KiallitasiTargy> rendeszKeszitoSzerint() {
        Collections.sort(targyak, KiallitasiTargy.keszitoRendez());
        return Collections.unmodifiableList(targyak);
    }

    @Override
    public Iterator<KiallitasiTargy> iterator() {
        return Collections.unmodifiableList(targyak).iterator();
    }

}
