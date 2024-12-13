package services;

import entities.Pesanan;

import java.util.List;

public class LaporanService {
    public void tampilkanLaporan(List<Pesanan> daftarPesanan, int totalPendapatan, String[] daftarBaju) {
        System.out.println("\n--- Laporan Penjualan ---");
        System.out.println("Total Pendapatan: Rp" + totalPendapatan);
        System.out.println("Detail Pesanan:");
        for (Pesanan pesanan : daftarPesanan) {
            System.out.println(pesanan);
        }
    }
}
