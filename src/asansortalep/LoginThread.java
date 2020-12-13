package asansortalep;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginThread implements Runnable {

    @Override
    public void run() {

        Random r = new Random();
        while (true) {
            int sayi = r.nextInt(10) + 1;       // kaç kişinin giriş yaptığı
            Avm.avmMusteriSayisi += sayi;
            Avm.katlar.get(0).katKuyruk += sayi;
            Avm.katlar.get(0).katMusteriSayisi += sayi;
            int kat = r.nextInt(4) + 1;
            int[] kuyruk = new int[2];
            kuyruk[0] = sayi;
            kuyruk[1] = kat;
            Avm.katlar.get(0).kuyruktakiler.add(kuyruk);  // ilgili katın kuyrukta bekleyen kişi sayısını artırdık
            for (int i = 0; i < sayi; i++) { // giriş yapan kişinin hangi kata gideceği
                Avm.musteriler.add(new Musteri(0, kat));
            }

            System.out.println("0. floor : queue : " + Avm.katlar.get(0).katKuyruk);
            for (int i = 1; i < Avm.katlar.size(); i++) {
                System.out.println(i + ". floor :all : " + Avm.katlar.get(i).katMusteriSayisi + "  queue : " + Avm.katlar.get(i).katKuyruk);
            }
            System.out.println("exit count : " + Avm.cikisYapanSayi);
            for (int i = 0; i < Avm.asansorler.size(); i++) {
                System.out.println("active :" + Avm.asansorler.get(i).isDurum());
                if (Main.asansorTiredler.get(i).getState().toString().equals("TIMED_WAITING")) { // asansörün çalışıp çalışmadığı kontrol edilir
                    System.out.println("\t\t mode :working");
                } else {
                    System.out.println("\t\t mode :idle");
                }
                System.out.println("\t\t floor:" + Avm.asansorler.get(i).getAktifKat());
                System.out.println("\t\t destination:" + Avm.asansorler.get(i).getGidecegiKat());
                if (Avm.asansorler.get(i).isYon() == true) {
                    System.out.println("\t\t direction:up");
                } else {
                    System.out.println("\t\t direction:down");
                }
                System.out.println("\t\t capacity:" + Avm.asansorler.get(i).getKapasite());
                System.out.println("\t\t count_inside:" + Avm.asansorler.get(i).getAktifKapasite());
                System.out.print("\t\t inside:[");
                for (int j = 0; j < 5; j++) {
                    if (Avm.asansorler.get(i).icindekiler[j][0] != 0) {
                        System.out.print("(" + Avm.asansorler.get(i).icindekiler[j][0] + ", " + j + ")");
                    }
                }
                System.out.print("]");
                System.out.println("");
            }
            for (int i = 0; i < Avm.katlar.size(); i++) {
                System.out.print(i+". floor : [");
                for (int j = 0; j < Avm.katlar.get(i).kuyruktakiler.size(); j++) {
                    System.out.print("[ "+Avm.katlar.get(i).kuyruktakiler.get(j)[0]+", "+Avm.katlar.get(i).kuyruktakiler.get(j)[1]+"] ");
                }
                System.out.print("]");
                System.out.println("");
            }
            System.out.println("\n\n------------------------------------------\n\n");
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(LoginThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
