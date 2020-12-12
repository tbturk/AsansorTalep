package asansortalep;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AsansorThread implements Runnable {

    int index;

    public AsansorThread(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        while (true) {

            //System.out.println("kuyruk tuple sayi: " + Avm.katlar.get(0).kuyruktakiler.size());
            for (int i = 0; i < Avm.katlar.get(0).kuyruktakiler.size(); i++) {
                System.out.println(Avm.katlar.get(0).kuyruktakiler.get(i)[0] + "," + Avm.katlar.get(0).kuyruktakiler.get(i)[1]);
            }
            System.out.println("");
            System.out.println("aktif kat: " + Avm.asansorler.get(index).getAktifKat() + " " + Avm.asansorler.get(index).getAktifKapasite());

            if (Avm.asansorler.get(index).isYon() == true && Avm.asansorler.get(index).getAktifKat() == 0) {

                int eklenenKisi = 0;
                int silinecekIndexAdet = 0;
                for (int i = 0; i < Avm.katlar.get(Avm.asansorler.get(index).getAktifKat()).kuyruktakiler.size(); i++) {
                    //System.out.println("balııım"+Avm.katlar.get(Avm.asansorler.get(index).getAktifKat()).kuyruktakiler.get(i)[0]);
                    if (Avm.katlar.get(Avm.asansorler.get(index).getAktifKat()).kuyruktakiler.get(i)[0] + eklenenKisi <= 10) {
                        eklenenKisi += Avm.katlar.get(Avm.asansorler.get(index).getAktifKat()).kuyruktakiler.get(i)[0];
                        silinecekIndexAdet++;
                        //asansöre ekleme islemi burda yapıldı /
                        Avm.asansorler.get(index).icindekiler[Avm.katlar.get(Avm.asansorler.get(index).getAktifKat()).kuyruktakiler.get(i)[1]][0] += Avm.katlar.get(Avm.asansorler.get(index).getAktifKat()).kuyruktakiler.get(i)[0];
                        Avm.asansorler.get(index).setAktifKapasite(eklenenKisi);
                    } else {
                        if (eklenenKisi < 10) { // asansörede 10dan az kişi var ise geri kalan kısmı doldurmak için işlemler
                            for (int j = 0; j < Avm.katlar.get(Avm.asansorler.get(index).getAktifKat()).kuyruktakiler.get(i)[0]; j++) {
                                eklenenKisi++;
                                //asansöre ekleme islemi yapılacak burda
                                Avm.asansorler.get(index).icindekiler[Avm.katlar.get(Avm.asansorler.get(index).getAktifKat()).kuyruktakiler.get(i)[1]][0] += 1;
                                Avm.asansorler.get(index).setAktifKapasite(eklenenKisi);
                                Avm.katlar.get(Avm.asansorler.get(index).getAktifKat()).kuyruktakiler.get(i)[0] = Avm.katlar.get(Avm.asansorler.get(index).getAktifKat()).kuyruktakiler.get(i)[0] - 1;
                                if (eklenenKisi == 10) {
                                    break;
                                }
                            }
                        }
                    }
                }
                Avm.katlar.get(Avm.asansorler.get(index).getAktifKat()).katKuyruk -= eklenenKisi;
                Avm.katlar.get(Avm.asansorler.get(index).getAktifKat()).katMusteriSayisi -= eklenenKisi;
                for (int i = 0; i < silinecekIndexAdet; i++) {
                    Avm.katlar.get(Avm.asansorler.get(index).getAktifKat()).kuyruktakiler.remove(0);
                }
                for (int i = 0; i < Avm.katlar.size(); i++) {
                    if (Avm.asansorler.get(index).icindekiler[i][0] != 0) {
                        Avm.asansorler.get(index).setGidecegiKat(i);
                        break;
                    }
                }

            }
            System.out.println("------------------");
            for (int i = 0; i < 5; i++) {
                System.out.println(Avm.asansorler.get(index).icindekiler[i][0] + "," + i);
            }
            System.out.println("------------------");
            System.out.println("");
            try {
                Thread.sleep(Avm.asansorler.get(index).getGecisZaman());
            } catch (InterruptedException ex) {
                Logger.getLogger(AsansorThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (Avm.asansorler.get(index).isYon() == true && Avm.asansorler.get(index).getAktifKapasite() != 0 && Avm.asansorler.get(index).getAktifKat() < Avm.asansorler.get(index).getGidecegiKat()) { //yukarı yönde gidiyorsa aktifkat artar.
                Avm.asansorler.get(index).setAktifKat(Avm.asansorler.get(index).getAktifKat() + 1);
            } else if (Avm.asansorler.get(index).isYon() == false && Avm.asansorler.get(index).getAktifKapasite() == 0 && Avm.asansorler.get(index).getAktifKat() > Avm.asansorler.get(index).getGidecegiKat()) { //aşağı yönde gidiyorsa aktifkat azalır
                Avm.asansorler.get(index).setAktifKat(Avm.asansorler.get(index).getAktifKat() - 1);
            }

            if (Avm.asansorler.get(index).getAktifKat() == Avm.asansorler.get(index).getGidecegiKat()) { // gideceği kata ulaştıysa;
                Avm.asansorler.get(index).setAktifKapasite(Avm.asansorler.get(index).getAktifKapasite() - Avm.asansorler.get(index).icindekiler[Avm.asansorler.get(index).getAktifKat()][0]);
                Avm.katlar.get(Avm.asansorler.get(index).getAktifKat()).katMusteriSayisi += Avm.asansorler.get(index).icindekiler[Avm.asansorler.get(index).getAktifKat()][0];
                Avm.asansorler.get(index).icindekiler[Avm.asansorler.get(index).getAktifKat()][0] = 0;
                boolean buldumu = false;
                for (int i = 0; i < Avm.katlar.size(); i++) {
                    if (Avm.asansorler.get(index).icindekiler[i][0] != 0) {
                        Avm.asansorler.get(index).setGidecegiKat(i);
                        buldumu = true;
                        break;
                    }
                }
                // asasnsör durumuna göre asansörün yönünü değiştirir.
                if (buldumu == false && Avm.asansorler.get(index).isYon() == true) {
                    Avm.asansorler.get(index).setGidecegiKat(0);
                    Avm.asansorler.get(index).setYon(false);
                } else if (buldumu == false && Avm.asansorler.get(index).isYon() == false) {
                    Avm.asansorler.get(index).setYon(true);
                }

            }
            // asansör aşağı inerken kattaki ve asansördeki kişi sayılarının güncellenmesi
            if (Avm.asansorler.get(index).isYon() == false && Avm.asansorler.get(index).getAktifKapasite() < 10 && Avm.asansorler.get(index).getAktifKat() != 0) {
                if (Avm.katlar.get(Avm.asansorler.get(index).getAktifKat()).kuyruktakiler.get(0)[0] + Avm.asansorler.get(index).getAktifKapasite() <= 10) {
                    Avm.katlar.get(Avm.asansorler.get(index).getAktifKat()).katKuyruk = 0;
                    Avm.katlar.get(Avm.asansorler.get(index).getAktifKat()).katMusteriSayisi -= Avm.katlar.get(Avm.asansorler.get(index).getAktifKat()).kuyruktakiler.get(0)[0];
                    Avm.katlar.get(Avm.asansorler.get(index).getAktifKat()).kuyruktakiler.get(0)[0] = 0;
                    Avm.asansorler.get(index).icindekiler[0][0] += Avm.katlar.get(Avm.asansorler.get(index).getAktifKat()).kuyruktakiler.get(0)[0];
                } else {
                    if (Avm.asansorler.get(index).getAktifKapasite() < 10) {
                        for (int i = 0; i < Avm.katlar.get(Avm.asansorler.get(index).getAktifKat()).kuyruktakiler.get(0)[0]; i++) {
                            Avm.katlar.get(Avm.asansorler.get(index).getAktifKat()).katKuyruk -= 1;
                            Avm.katlar.get(Avm.asansorler.get(index).getAktifKat()).kuyruktakiler.get(0)[0] -= 1;
                            Avm.katlar.get(Avm.asansorler.get(index).getAktifKat()).katMusteriSayisi -= 1;
                            Avm.asansorler.get(index).icindekiler[0][0] += 1;
                            if (Avm.asansorler.get(index).getAktifKapasite() == 10) {
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

}
