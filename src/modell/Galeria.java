
package modell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Galeria {
    private ArrayList<KiallitasiTargy> targyak;

    public Galeria(ArrayList<KiallitasiTargy> targyak) {
       targyak = new ArrayList<>();
    }
    
    public List<KiallitasiTargy> rendezCimSzerint(){
        Collections.sort(targyak,KiallitasiTargy.cimRendez());
        return Collections.unmodifiableList(targyak);
    }
    
    public List<KiallitasiTargy> rendeszKeszitoSzerint(){
        Collections.sort(targyak, KiallitasiTargy.keszitoRendez());
        return Collections.unmodifiableList(targyak);
    }
   
}
