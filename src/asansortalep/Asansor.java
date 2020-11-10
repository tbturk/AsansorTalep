package asansortalep;

public class Asansor {

    private boolean durum;
    private final int kapasite;
    private final int gecisZaman;
    private int aktifKapasite;

    public Asansor() {
        this.durum = false;
        this.kapasite = 10;
        this.gecisZaman = 200;
        this.aktifKapasite = 0;
    }

    /**
     * @return the durum
     */
    public boolean isDurum() {
        return durum;
    }

    /**
     * @param durum the durum to set
     */
    public void setDurum(boolean durum) {
        this.durum = durum;
    }

    /**
     * @return the kapasite
     */
    public int getKapasite() {
        return kapasite;
    }

    /**
     * @return the gecisZaman
     */
    public int getGecisZaman() {
        return gecisZaman;
    }

    /**
     * @return the aktifKapasite
     */
    public int getAktifKapasite() {
        return aktifKapasite;
    }

    /**
     * @param aktifKapasite the aktifKapasite to set
     */
    public void setAktifKapasite(int aktifKapasite) {
        this.aktifKapasite = aktifKapasite;
    }

}
