package Entity;
public class daftarpembeli {
    private PembeliEntity pembeli;
    private boolean isVerified;
    private int indexBarang;
    public daftarpembeli(PembeliEntity pembeli, boolean isVerified, int indexBarang) {
        this.pembeli = pembeli;
        this.isVerified = isVerified;
        this.indexBarang = indexBarang;
    }
    public PembeliEntity getPembeli() {
        return pembeli;
    }
    public void setPembeli(PembeliEntity pembeli) {
        this.pembeli = pembeli;
    }
    public boolean isIsVerified() {
        return isVerified;
    }
    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }
    public int getindexBarang() {
        return indexBarang;
    }
    public void setIndexBarang(int indexBarang) {
        this.indexBarang = indexBarang;
    }
}
