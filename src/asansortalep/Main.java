package asansortalep;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static ArrayList<Asansor> asansorleriOlustur() {
        ArrayList<Asansor> asansorDizi = new ArrayList<>();
        for (int i = 0; i < avm.getAsansorSayisi(); i++) {
            asansorDizi.add(new Asansor());
        }
        return asansorDizi;
    }

    static Avm avm = new Avm();
    static ArrayList<Thread> asansorTiredler = new ArrayList();    

    public static void main(String[] args) {
        Avm.asansorler=asansorleriOlustur();                
        Avm.asansorler.get(0).setDurum(true); // ilk asansör default aktif olarak tanımlanır
        Avm.aktifAsansorSayisi += 1;
        
        ExecutorService executor = Executors.newFixedThreadPool(8); //  belli bir anda en fazla kaç Thread çalıştırmak istediğimizi belirtiyoruz.
        Thread giris = new Thread(new LoginThread());
        Thread cikis = new Thread(new ExitThread());
        Thread kontrol = new Thread(new KontrolThread());
        
        for (int i = 0; i < 5; i++) {
            asansorTiredler.add(new Thread(new AsansorThread(i)));
            asansorTiredler.get(i).start();
            asansorTiredler.get(i).suspend();
        }
        
        giris.start();
        kontrol.start();
        asansorTiredler.get(0).resume();
        cikis.start();
    }

}
