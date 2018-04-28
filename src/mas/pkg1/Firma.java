package mas.pkg1;

import java.io.Serializable;

public final class Firma
        implements Serializable {

    private String miasto;
    private String ulica;
    private String kodPocztowy;

    public Firma(String miasto, String ulica, String kodPocztowy) {
        setMiasto(miasto);
        setUlica(ulica);
        setKodPocztowy(kodPocztowy);
    }

    public void setKodPocztowy(String kodPocztowy) {
        if (kodPocztowy == null) {
            throw new NullPointerException("Adres musi miec kod pocztowy");
        }
        this.kodPocztowy = kodPocztowy;

    }

    public void setMiasto(String miasto) {
        if (miasto == null) {
            throw new NullPointerException("Adres musi miec miasto");
        }
        this.miasto = miasto;
    }

    public void setUlica(String ulica) {
        if (ulica == null) {
            throw new NullPointerException("Adres musi miec ulice");
        }
        this.ulica = ulica;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public String getMiasto() {
        return miasto;
    }

    public String getUlica() {
        return ulica;
    }
    
    
    @Override
    public String toString() {
        return getMiasto() + ", " + getUlica() + ", " + getKodPocztowy();
    }

}

