package asansortalep;
import java.util.Random;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoginThread implements Runnable{

    @Override
    public void run() {
        Random r=new Random();
        ExecutorService executor = Executors.newFixedThreadPool(5); //  belli bir anda en fazla kaç Thread çalıştırmak istediğimizi belirtiyoruz.
        while(true){            
            int sayi=r.nextInt(10)+1;
            int kat=r.nextInt(4)+1;
            for(int i=0; i<sayi;i++){
                Avm.musteriler.add(new Musteri(0,kat));
                Avm.avmMusteriSayisi++;
            }
            System.out.println(Avm.avmMusteriSayisi);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(LoginThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
