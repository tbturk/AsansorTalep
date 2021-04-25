package asansortalep;

public class Asansor {

    //*** DEĞİŞKEN TANIMLAMALARI ***/
    private boolean durum;   // true: asansör aktif    false: asansör pasif
    static final int kapasite = 10; // Asansörlerin maksimum kapasitesi 10
    private final int gecisZaman; // Asansörlerdeki kat arası geçiş 200 ms
    private int aktifKapasite;  // [0-10]
    private int aktifKat;       // [0-4]
    private int gidecegiKat;    // [0-4]
    private boolean yon;     // true: yukarı    false: aşağı
    int[][] icindekiler;

    public Asansor() {
        this.durum = false;
        this.gecisZaman = 200;
        this.aktifKapasite = 0;
        this.aktifKat = 0;
        icindekiler = new int[5][1];
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
