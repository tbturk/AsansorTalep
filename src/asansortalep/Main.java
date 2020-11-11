package asansortalep;
import java.util.ArrayList;

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
       /* Thread basla= new Thread(new LoginThread());
        basla.start();*/
       
        ArrayList<int[]> icindekiler = new ArrayList<>();
        int array[]={0,2};
        icindekiler.add(array);
        System.out.println(icindekiler.get(0)[1]);

    }

}
