package asansortalep;

import java.util.logging.Level;
import java.util.logging.Logger;

public class KontrolThread implements Runnable {

    @Override
    public void run() {
        while (true) {
            int kuyruktakiSayi = 0;
            for (int i = 0; i < Avm.katlar.size(); i++) {
                kuyruktakiSayi += Avm.katlar.get(i).katKuyruk;
            }
            if (kuyruktakiSayi > Asansor.kapasite * 2 && Avm.sonAsansorIndex < Avm.asansorler.size() - 1) {  // kuyrukta bekleyen kişi sayısı asansör kapasitesinin iki katını aştığında
                Avm.sonAsansorIndex++;
                Avm.asansorler.get(Avm.sonAsansorIndex).setDurum(true);
                Main.asansorTiredler.get(Avm.sonAsansorIndex).resume();
            }
            if (kuyruktakiSayi < Asansor.kapasite * 2 && Avm.sonAsansorIndex > 0) {  // kuyrukta bekleyen kişi sayısı asansör kapasitesinin iki katını aştığında
                Avm.sonAsansorIndex--;
                Avm.asansorler.get(Avm.sonAsansorIndex + 1).setDurum(false);
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(LoginThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
