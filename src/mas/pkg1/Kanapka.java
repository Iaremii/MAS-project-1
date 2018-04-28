/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas.pkg1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

public class Kanapka implements Serializable {

    private String nazwa;                                       // ATRYBUT PROSTY , wymagany , pojedynczy , obiektu
    private Firma adres;                                        // ATRYBUT zlozony
    private ArrayList<String> zamowienia;                       // ATRYBUT powtarzalny 
    private String kodRabatowy;                                 // ATRYBUT prosty, opcjonalny, pojedynczy, obiektu
    private int sztuk = 0;                                      // ATRYBUT prosty, wymagany dla sredniej
    private static double sredniaIloscSprzedanychKanapek = 0;   // ATRYBUT pochodny , klasowy
    private static int iloscKanapek = 0;                        // ATRYBUT klasowy

    public Kanapka(String nazwa, int sztuk, Firma adres, ArrayList<String> zamowienia) {
        setNazwa(nazwa);
        setAdres(adres);
        setZamowienia(zamowienia);
        this.sztuk = sztuk;
        iloscKanapek++;
        dodajKanapke(this);
        sredniaIloscSprzedanychKanapek += (this.sztuk - sredniaIloscSprzedanychKanapek) / iloscKanapek;
    }
      

    public void setNazwa(String nazwa) {
        if (nazwa == null) {
            throw new NullPointerException("Kanapka musi miec nazwe");
        }
        this.nazwa = nazwa;
    }
        
    public void setZamowienia(ArrayList<String> zamowienia) {
        if (zamowienia != null) {
            zamowienia = new ArrayList<>();
            this.zamowienia = zamowienia;
        } else {
            throw new RuntimeException("Invalid value - zamowienie is null");
        }
    }
    
    public void setKodRabatowy(String kodRabatowy) {
        if (kodRabatowy != null) {
            this.kodRabatowy = kodRabatowy;
        } else {
            kodRabatowy = "brak kody rabatowego.";
        }
    }
     public void setAdres(Firma adres) {
        if (adres != null) {
            this.adres = adres;
        } else {
            throw new RuntimeException("Invalid value - adres is null");
        }
    }

    public Firma getAdres() {
        return adres;
    }

    public static double getSredniaIloscSprzedanychKanapek() {
        return sredniaIloscSprzedanychKanapek;
    }
    
    public String getKodRabatowy() {                    //METODA obiektu
        return kodRabatowy;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getSztuk() {
        return sztuk;
    }    

    public ArrayList<String> getZamowienia() {
        return zamowienia;
    }
    
    public void dodajSkladnikDodatkowy(String napoj) throws Exception {
        if (napoj != null) {
            zamowienia.add(napoj);
        } else {
            throw new Exception("Napoj musi miec nazwe");
        }

    }

    public void dodajSkladnikDodatkowy(String napoj, String sos) throws Exception {
        if (napoj != null || sos != null) {
            String zestaw = napoj + ", " + sos;
            zamowienia.add(zestaw);
        } else {
            throw new Exception("Napoj i sos musi miec nazwe");
        }
    }
  

    //EKSTENZJA tej samej klasy
    private static Vector<Kanapka> ekstensja = new Vector<Kanapka>();

    private static void dodajKanapke(Kanapka kanapka) {
        ekstensja.add(kanapka);
    }

    private static void usunKanapke(Kanapka kanapka) {
        ekstensja.remove(kanapka);
    }

    public static void pokazEkstensje() {               //METODA KLASOWA
        System.out.println("Ekstensja klasy Kanapka");
        for (Kanapka kanapka : ekstensja) {
            System.out.println(kanapka);
        }
    }

   

    public static void zapiszEkstensje(ObjectOutputStream stream)
            throws IOException {
        stream.writeObject(ekstensja);
    }

    public static void odczytajEkstensje(ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        ekstensja = (Vector<Kanapka>) stream.readObject();
    }

    @Override
    public String toString() {                          //Przesłonięcie metody
        String zamowienie = new String();
        zamowienie = "Kanapka : " + getNazwa() + ", Ilosc : " + getSztuk() + ", Kod Rabatowy : " + getKodRabatowy() + ", Adres: " + getAdres() + " " + ", Skladniki dodatkowe : " + getZamowienia();
        return zamowienie;
    }

}

