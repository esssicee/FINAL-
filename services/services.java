package services;

import entities.Pesanan;

import java.util.ArrayList;
import java.util.List;

public class PemesananService {
    private List<Pesanan> daftarPesanan = new ArrayList<>();
    private int totalPendapatan = 0;

    public void tambahPesanan(Pesanan pesanan) {
        daftarPesanan.add(pesanan);
        totalPendapatan += pesanan.totalHarga;
    }

    public List<Pesanan> getDaftarPesanan() {
        return daftarPesanan;
    }

    public int getTotalPendapatan() {
        return totalPendapatan;
    }
}
