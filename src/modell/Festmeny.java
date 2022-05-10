
package modell;

import java.io.File;
import java.time.LocalDate;

public class Festmeny extends KiallitasiTargy{
    private File eleres;

    public Festmeny(String cim, String keszito) throws HibasDatumException {
       this(new File("nincs"),cim, keszito);
    }

    public Festmeny(LocalDate letrehozas, String cim, String keszito) throws HibasDatumException {
       this(new File("nincs"),letrehozas, cim, keszito);
    }
    
    public Festmeny(File eleres, String cim, String keszito) throws HibasDatumException {
      this(eleres,LocalDate.now(), cim, keszito);
    }

    public Festmeny(File eleres, LocalDate letrehozas, String cim, String keszito) throws HibasDatumException {
        super(letrehozas, cim, keszito);
        this.eleres = eleres;
    }
    
    public void megjelenit(){
        if(eleres.exists()){
            System.out.println("Megjelenítés folyamatban...");
        }else{
            System.out.println("Nem lehet megjeleníteni!");
        }
    }
    
    

    @Override
    public String toString() {
        String kiir = super.toString();
        return kiir+"Festmény{" + "elérés=" + eleres + '}';
    }
    
    
    
    
}
