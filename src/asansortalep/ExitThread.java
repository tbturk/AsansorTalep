package asansortalep;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExitThread implements Runnable {

    @Override
    public void run() {
        Random r = new Random();
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(LoginThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            int kat;
            int cikisSayi;
            cikisSayi = r.nextInt(5) + 1;       // kaç kişinin çıkış yapacağı
            kat = r.nextInt(4) + 1;             //kişilerin hangi kattan çıkmak istediği
            while (Avm.katlar.get(kat).katMusteriSayisi < cikisSayi) {
                cikisSayi = r.nextInt(5) + 1;
                kat = r.nextInt(4) + 1;
            }
            Avm.katlar.get(kat).katKuyruk += cikisSayi;
            Avm.katlar.get(kat).kuyruktakiler.get(0)[0] += cikisSayi;
        }

    }

}
