
package main;

import modell.Festmeny;
import modell.Galeria;
import modell.KiallitasiTargy;

public class Program {

  
    public static void main(String[] args) {
        Galeria galeria = new Galeria();
        
        System.out.println("cím szerinti rendezes:");
        for (KiallitasiTargy targy : galeria) {
            System.out.println(targy);
        }
        
        System.out.println("készitő szerinti rendezés");
        for (KiallitasiTargy targy : galeria) {
            System.out.println(targy);
        }
        
        for (KiallitasiTargy targy : galeria) {
            if(targy instanceof Festmeny){
                ((Festmeny)targy).megjelenit();
            }
        }
    }
    
}
