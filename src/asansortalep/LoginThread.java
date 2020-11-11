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
            for (int i = 0; i < sayi; i++) {
                int kat = r.nextInt(4) + 1;     // giriş yapan kişinin hangi kata gideceği
                Avm.musteriler.add(new Musteri(0, kat));
                Avm.katlar.get(0).kuyruktakiler.get(kat)[0] += 1;   // ilgili katın kuyrukta bekleyen kişi sayısını artırdık
            }
            /*
            System.out.println("[" + Avm.katlar.get(0).kuyruktakiler.get(1)[0] + ",1]");
            System.out.println("[" + Avm.katlar.get(0).kuyruktakiler.get(2)[0] + ",2]");
            System.out.println("[" + Avm.katlar.get(0).kuyruktakiler.get(3)[0] + ",3]");
            System.out.println("[" + Avm.katlar.get(0).kuyruktakiler.get(4)[0] + ",4]");
            System.out.println(Avm.avmMusteriSayisi);*/
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(LoginThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
