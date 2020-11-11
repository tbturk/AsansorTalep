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
            int sayi = r.nextInt(5) + 1;       // kaç kişinin çıkış yapacağı
            int belirlenen = 0;
            while (belirlenen < sayi) {
                int kat = r.nextInt(4) + 1;
                if (Avm.katlar.get(kat).katMusteriSayisi != 0) {                    
                    Avm.katlar.get(kat).katKuyruk++;
                    Avm.katlar.get(kat).kuyruktakiler.get(0)[0]++;
                    belirlenen++;
                }
            }

        }

    }

}
