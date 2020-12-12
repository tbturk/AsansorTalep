package asansortalep;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginThread implements Runnable {

    @Override
    public void run() {
        
        Random r = new Random();
        while (true) {
            //System.out.println("1");
            int sayi = r.nextInt(10) + 1;       // kaç kişinin giriş yaptığı
            Avm.avmMusteriSayisi += sayi;
            Avm.katlar.get(0).katKuyruk += sayi;
            Avm.katlar.get(0).katMusteriSayisi += sayi;
            int kat = r.nextInt(4) + 1; 
            int[] kuyruk = new int[2];
            kuyruk[0]=sayi;
            kuyruk[1]=kat;
            Avm.katlar.get(0).kuyruktakiler.add(kuyruk);  // ilgili katın kuyrukta bekleyen kişi sayısını artırdık
            for (int i = 0; i < sayi; i++) { // giriş yapan kişinin hangi kata gideceği
                Avm.musteriler.add(new Musteri(0, kat));              
            }            
           
            
            //System.out.println(Avm.katlar.get(0).katKuyruk);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(LoginThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
