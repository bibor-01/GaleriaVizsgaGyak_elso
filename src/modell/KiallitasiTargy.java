package modell;

import java.io.Serializable;
import java.text.Collator;
import java.time.LocalDate;
import java.util.Comparator;

class keszitoComparator implements Comparator<KiallitasiTargy> {

    @Override
    public int compare(KiallitasiTargy egyik, KiallitasiTargy masik) {
        Collator col = Collator.getInstance();
        return col.compare(egyik.getKeszito(), masik.getKeszito());
    }
}

class cimComparator implements Comparator<KiallitasiTargy> {

    @Override
    public int compare(KiallitasiTargy egyik, KiallitasiTargy masik) {
        Collator col = Collator.getInstance();
        return col.compare(egyik.getCim(), masik.getCim());
    }

}

public abstract class KiallitasiTargy implements Serializable{

    private LocalDate letrehozas;
    private String cim, keszito;

    public KiallitasiTargy(String cim, String keszito) throws HibasDatumException {
        this(LocalDate.now(), cim, keszito);
    }

    public KiallitasiTargy(LocalDate letrehozas, String cim, String keszito) throws HibasDatumException {
        if (letrehozas.isAfter(LocalDate.now())) {
            throw new HibasDatumException("Nem létező dátum");
        }
        this.letrehozas = letrehozas;
        this.cim = cim;
        this.keszito = keszito;
    }

    public LocalDate getLetrehozas() {
        return letrehozas;
    }

    public String getCim() {
        return cim;
    }

    public String getKeszito() {
        return keszito;
    }

    public static cimComparator cimRendez() {
        return new cimComparator();
    }
    
    public static keszitoComparator keszitoRendez(){
        return new keszitoComparator();
    }

    @Override
    public String toString() {
        return "KiallitasiTargy{" + "letrehozas=" + letrehozas + ", cim=" + cim + ", keszito=" + keszito + '}';
    }

}
