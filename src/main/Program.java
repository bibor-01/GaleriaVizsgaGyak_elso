package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import modell.Festmeny;
import modell.Galeria;
import modell.KiallitasiTargy;

public class Program {

    public static void main(String[] args) throws IOException {
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
            if (targy instanceof Festmeny) {
                ((Festmeny) targy).megjelenit();
            }
        }

        //kiírás:
        try {
            FileOutputStream fileOut = new FileOutputStream("galeria.bin");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(galeria);
            out.close();
            fileOut.close();
            System.out.printf("sikeres kiírás!");
        } catch (IOException i) {
            i.printStackTrace();
        }
        galeria = null;

        //Visszaolvasás
       try {
            ObjectInputStream objBe = new ObjectInputStream(new FileInputStream("galeria.bin"));
            galeria = (Galeria)objBe.readObject();
            objBe.close();          
            System.out.println("Visszaállítás:");
            for (KiallitasiTargy targy : galeria) {
                System.out.println(targy);
            }           
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Sikertelen beolvasás!");
            c.printStackTrace();
            return;
        }
    }

}
