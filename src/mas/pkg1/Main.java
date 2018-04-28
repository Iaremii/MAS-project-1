package mas.pkg1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author oleksandr.iaremii
 */

// Oleksandr Iaremii s14454
public class Main {

    public static void main(String[] args) throws Exception {
        try {
            String ekstensjaPlik = "ekstensja";
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ekstensjaPlik));
            Kanapka.zapiszEkstensje(out);
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(ekstensjaPlik));
            Kanapka.odczytajEkstensje(in);
            
        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (ClassNotFoundException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        }

        ArrayList<String> skladniki = new ArrayList<>();
        
        Kanapka kanapka = new Kanapka("Beef Melt", 5, new Firma("Warszawa", "ul.Odkryta", "01-132"), skladniki);
        kanapka.dodajSkladnikDodatkowy("woda");
        kanapka.setKodRabatowy("22452");
        System.out.println(kanapka);

        Kanapka kanapka2 = new Kanapka("Sandwicz szynka", 8, new Firma("Warszawa", "ul.Budy", "01-333"), skladniki);
        kanapka2.dodajSkladnikDodatkowy("coca cola","ketczup");
        System.out.println(kanapka2);

        System.out.println(Kanapka.getSredniaIloscSprzedanychKanapek());

    }

}

