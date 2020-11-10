package asansortalep;
import java.util.ArrayList;

class Musteri{
    int aktifKat;
    int gidecegiKat;

    public Musteri(int aktifKat, int gidecegiKat) {
        this.aktifKat = aktifKat;
        this.gidecegiKat = gidecegiKat;
    }
    
}

class Kat{
    private int katMusteriSayisi;
}

public class Avm {

    private final int katSayisi;
    private final int asansorSayisi;
    static int aktifAsansorSayisi;
    static int avmMusteriSayisi;
    static ArrayList<Kat> katlar;
    static ArrayList<Musteri> musteriler;

    public Avm() {
        this.katSayisi = 5;
        this.asansorSayisi = 5;
        aktifAsansorSayisi = 0;
        avmMusteriSayisi = 0;
        musteriler = new ArrayList<>();
        katlar = new ArrayList<>();
        for (int i = 0; i < katSayisi; i++) {
            katlar.add(new Kat());
        }
    }

    public int getKatSayisi() {
        return katSayisi;
    }

    public int getAsansorSayisi() {
        return asansorSayisi;
    }

}
