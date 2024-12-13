package entities;

public class Pesanan {
    private String namaBaju;
    private String ukuran;
    private int jumlah;
    private int totalHarga;

    // Constructor
    public Pesanan(String namaBaju, String ukuran, int jumlah, int totalHarga) {
        this.namaBaju = namaBaju;
        this.ukuran = ukuran;
        this.jumlah = jumlah;
        this.totalHarga = totalHarga;
    }

    // Getter dan Setter
    public String getNamaBaju() {
        return namaBaju;
    }

    public void setNamaBaju(String namaBaju) {
        this.namaBaju = namaBaju;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }

    // toString() Method
    @Override
    public String toString() {
        return "Pesanan{" +
                "namaBaju='" + namaBaju + '\'' +
                ", ukuran='" + ukuran + '\'' +
                ", jumlah=" + jumlah +
                ", totalHarga=" + totalHarga +
                '}';
    }
}
