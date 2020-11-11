package asansortalep;

import java.util.ArrayList;

class Musteri {

    int aktifKat;
    int gidecegiKat;

    public Musteri(int aktifKat, int gidecegiKat) {
        this.aktifKat = aktifKat;
        this.gidecegiKat = gidecegiKat;
    }

}

class Kat {

    int katMusteriSayisi;
    int katKuyruk;    
    ArrayList<int[]> kuyruktakiler;

    public Kat() {
        this.katKuyruk = 0;
        this.katMusteriSayisi = 0;
        kuyruktakiler = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int array[]={0,i};
            kuyruktakiler.add(array);
        }
    }
}

public class Avm {

    private final int katSayisi;
    private final int asansorSayisi;
    static int aktifAsansorSayisi;
    static int avmMusteriSayisi;
    static ArrayList<Kat> katlar;
    static ArrayList<Musteri> musteriler;
    static ArrayList<Asansor> asansorler;

    public Avm() {
        this.katSayisi = 5;
        this.asansorSayisi = 5;
        aktifAsansorSayisi = 0;
        avmMusteriSayisi = 0;
        katlar = new ArrayList<>();
        musteriler = new ArrayList<>();
        asansorler = new ArrayList<>();
        for (int i = 0; i < katSayisi; i++) {
            katlar.add(new Kat());
            asansorler.add(new Asansor());
        }
    }

    public int getKatSayisi() {
        return katSayisi;
    }

    public int getAsansorSayisi() {
        return asansorSayisi;
    }

}
