package semester1.chapter10.Task1;

public class Artikel {
    private int artikelNr;
    private float einzelPreis;
    private int menge;
    
    public Artikel(int artikelNr, float einzelPreis, int menge) {
        this.artikelNr = artikelNr;
        this.einzelPreis = einzelPreis;
        this.menge = menge;
    }

    public float getUmsatz() {
        return menge * einzelPreis;
    }

    public int getArtikelNr() {
        return artikelNr;
    }
}