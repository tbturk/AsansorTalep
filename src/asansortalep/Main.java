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
        asansorDizi.get(0).setDurum(true); // ilk asansör default aktif olarak tanımlanır
        Avm.aktifAsansorSayisi+=1;
        return asansorDizi;
    }

    static Avm avm = new Avm();
    static ArrayList<Asansor> asansorler = asansorleriOlustur();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(8); //  belli bir anda en fazla kaç Thread çalıştırmak istediğimizi belirtiyoruz.
        Thread basla= new Thread(new LoginThread());
        basla.start();      

    }

}
