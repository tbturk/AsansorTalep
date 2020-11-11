package asansortalep;

import java.util.ArrayList;

public class Asansor {

    //*** DEĞİŞKEN TANIMLAMALARI ***/
    private boolean durum;   // true: çalışıyor    false: boşta
    private final int kapasite;
    private final int gecisZaman;
    private int aktifKapasite;  // [0-10]
    private int aktifKat;       // [0-4]
    private int gidecegiKat;    // [1-4]
    private boolean yon;     // true: yukarı    false: aşağı
    ArrayList<int[]> icindekiler;
    public Asansor() {
        this.durum = false;
        this.kapasite = 10;
        this.gecisZaman = 200;
        this.aktifKapasite = 0;
        this.aktifKat = 0;
        icindekiler = new ArrayList<>();
        this.yon = true;
    }

    //*** GETTER VE SETTERLER ***//
    public int getAktifKat() {
        return aktifKat;
    }

    public void setAktifKat(int aktifKat) {
        this.aktifKat = aktifKat;
    }

    public int getGidecegiKat() {
        return gidecegiKat;
    }

    public void setGidecegiKat(int gidecegiKat) {
        this.gidecegiKat = gidecegiKat;
    }

    public boolean isDurum() {
        return durum;
    }

    public void setDurum(boolean durum) {
        this.durum = durum;
    }

    public int getKapasite() {
        return kapasite;
    }

    public int getGecisZaman() {
        return gecisZaman;
    }

    public int getAktifKapasite() {
        return aktifKapasite;
    }

    public void setAktifKapasite(int aktifKapasite) {
        this.aktifKapasite = aktifKapasite;
    }

    public boolean isYon() {
        return yon;
    }

    public void setYon(boolean yon) {
        this.yon = yon;
    }
}
