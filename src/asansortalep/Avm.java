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

    int katMusteriSayisi; // kuyruktakiler + gezenler
    int katKuyruk;    // kuyruktaki kişi sayısı
    ArrayList<int[]> kuyruktakiler; // kaç kişinin hangi kata gitmek istediği

    public Kat() {
        this.katKuyruk = 0;
        this.katMusteriSayisi = 0; 
        kuyruktakiler = new ArrayList();
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
    static int sonAsansorIndex=0;
    static int cikisYapanSayi=0;
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
        for (int i = 1; i < katSayisi; i++) {
            katlar.get(i).kuyruktakiler.add(new int[2]);
        }
        
    }

    public int getKatSayisi() {
        return katSayisi;
    }

    public int getAsansorSayisi() {
        return asansorSayisi;
    }

}
