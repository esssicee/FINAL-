package services;

import entities.Pesanan;

import java.util.ArrayList;
import java.util.List;

public class PemesananService {
    private final List<Pesanan> daftarPesanan = new ArrayList<>();
    private int totalPendapatan = 0;

    public void tambahPesanan(Pesanan pesanan) {
        if (pesanan != null && pesanan.getTotalHarga() >= 0) {
            daftarPesanan.add(pesanan);
            totalPendapatan += pesanan.getTotalHarga();
        } else {
            throw new IllegalArgumentException("Pesanan tidak valid");
        }
    }

    public List<Pesanan> getDaftarPesanan() {
        return new ArrayList<>(daftarPesanan); // Mengembalikan salinan untuk mencegah modifikasi langsung
    }

    public int getTotalPendapatan() {
        return totalPendapatan;
    }
}