package entities;

public class Pesanan {
    private String baju;
    private String ukuran;
    private int jumlah;
    private int totalHarga;

    public Pesanan(String baju, String ukuran, int jumlah, int totalHarga) {
        this.baju = baju;
        this.ukuran = ukuran;
        this.jumlah = jumlah;
        this.totalHarga = totalHarga;
    }

    // Getter methods
    public String getBaju() {
        return baju;
    }

    public String getUkuran() {
        return ukuran;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    // Setter methods
    public void setBaju(String baju) {
        this.baju = baju;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }

    @Override
    public String toString() {
        return "Baju: " + baju + "\nUkuran: " + ukuran + "\nJumlah: " + jumlah + "\nTotal Harga: Rp" + totalHarga;
    }
}
